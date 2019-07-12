package semanticdbpoc

import better.files.File

import scala.meta.internal.semanticdb.{SymbolInformation, SymbolOccurrence, TextDocument, TextDocuments}

object SemanticUtil {

  def getSymbolForFile(symbol: String, file: File): SymbolOccurrence =
    file.inputStream apply { inputStream =>
      val td = TextDocuments.parseFrom(inputStream)
      td.documents.flatMap(_.occurrences.find(_.symbol == symbol)).head
    }

  def findSymbolInformation(symbolToFind: String, documents: Seq[TextDocument]): Option[SymbolInformation] =
    documents
      .flatMap(_.symbols)
      .find(symbol => {
        symbol.symbol == symbolToFind
      })

  def checkIfHasSymbol(symbol: SymbolInformation, toFind: SymbolInformation): Boolean = ???

}

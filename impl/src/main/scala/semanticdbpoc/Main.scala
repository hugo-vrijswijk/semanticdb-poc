package semanticdbpoc

import better.files.File
import semanticdbpoc.ClassPathResolver._
import semanticdbpoc.SemanticUtil._

object Main extends App {
  // Setup
  val classpath = resolveClasspath()
  val documents = resolveTextDocuments(classpath)

  // Find symbols
  val filterOccurence = getSymbolForFile(
    "scala/collection/immutable/List#filter().",
    File("../testproj/target/scala-2.13/meta/META-INF/semanticdb/src/main/scala/example/Example.scala.semanticdb")
  )
  val filterInfo = findSymbolInformation(filterOccurence.symbol, documents).get
  println(s"SymbolInformation filter: $filterInfo")

  val filterNot = findSymbolInformation("scala/collection/immutable/List#filterNot().", documents).get
  println(s"SymbolInformation filterNot: $filterNot")

  // Checks
  val hasFilterNot = checkIfHasSymbol(filterInfo, filterNot)
  println(s"filter in $filterOccurence has 'filterNot': $hasFilterNot")
}

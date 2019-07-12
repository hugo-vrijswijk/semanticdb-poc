package semanticdbpoc

import java.nio.file.{Files, Paths}

import better.files.File

import scala.meta.cli.{Metacp, Metap, Reporter}
import scala.meta.internal.semanticdb.{SymbolInformation, TextDocuments}
import scala.meta.io.Classpath
import scala.meta.metacp.{Settings => McpSettings}
import scala.meta.metap.{Settings => MpSettings}

object Main extends App {
  // private val scalaLibJar =
  //   (File.home / ".cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.0/scala-library-2.13.0.jar").path
  // val settings = McpSettings()
  //   .withClasspath(Classpath(scalaLibJar))
  //   .withUsejavacp(true)

  // val result = Metacp.process(settings, Reporter())
  // val cp = result.classpath.get

  // val metap = Metap.process(
  //   MpSettings().withPaths(cp.entries.map(_.toNIO)),
  //   Reporter().withSilentOut()
  // )

//  cp.entries
//    .map(_.toNIO)
//    .map(Files.newInputStream(_))
//    .map(Metap.process(MpSettings().).parseFrom) map { si =>
//    si
//  }
//  private val scalalibSemanticDb = File("out/scala-library-2.12.8.jar")
//  scalalibSemanticDb.inputStream.apply { scalalib =>
//    val scalasemantic = SymbolInformation.parseFrom(cp.scalalib)
//    val a = "fhasdf"
//  }

 File(
   "../testproj/target/scala-2.13/meta/META-INF/semanticdb/src/main/scala/example/Example.scala.semanticdb"
 ).inputStream apply { stryker4s =>
   val td = TextDocuments.parseFrom(stryker4s)
   for {
     ref <- td.documents
     occurence <- ref.occurrences
     if occurence.role.isReference
   } yield println(occurence)
 }

}

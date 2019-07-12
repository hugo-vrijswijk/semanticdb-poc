package semanticdbpoc

import better.files.File

import scala.collection.mutable.ListBuffer
import scala.meta.cli.{Metacp, Reporter}
import scala.meta.internal.semanticdb.{Locator, TextDocument}
import scala.meta.io.Classpath
import scala.meta.metacp.Settings

object ClassPathResolver {

  private val isWindows = sys.props("os.name").toLowerCase().startsWith("windows")
  private val coursierLocation = File.home / (if (isWindows) "AppData/Local/Coursier/cache" else ".cache/coursier")
  private val rtJar = File(sys.env("JAVA_HOME")) / "jre" / "lib" / "rt.jar" // TODO: Is not in Java 11?

  def resolveClasspath(): Classpath = {
    val scalaLibJar = coursierLocation / "v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.0/scala-library-2.13.0.jar"
    val settings = Settings()
      .withClasspath(Classpath(scalaLibJar.path))
      .withDependencyClasspath(Classpath(rtJar.path))

    val result = Metacp.process(settings, Reporter().withSilentOut())
    result.classpath.get
  }

  def resolveTextDocuments(classpath: Classpath): Seq[TextDocument] = {
    val documents = ListBuffer[TextDocument]()
    Locator(classpath.entries.map(_.toNIO))((_, document) => documents.appendAll(document.documents))
    documents
  }
}

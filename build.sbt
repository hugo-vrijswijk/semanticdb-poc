name := "semanticdb-poc"

version := "0.1"

scalaVersion := "2.12.8"
lazy val scalametaV = "4.1.10"
libraryDependencies ++= Seq(
  "org.scalameta" %% "scalameta" % scalametaV,
  "com.github.pathikrit" %% "better-files" % "3.8.0"
)

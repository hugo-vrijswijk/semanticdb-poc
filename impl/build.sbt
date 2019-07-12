name := "semanticdb-poc"

version := "0.1"
ThisBuild / turbo := true
scalaVersion := "2.12.8"
lazy val scalametaV = "4.1.6"
libraryDependencies ++= Seq(
  "org.scalameta" %% "scalameta" % scalametaV,
  "org.scalameta" %% "metap" % scalametaV,
  "org.scalameta" %% "metacp" % scalametaV,
  "com.github.pathikrit" %% "better-files" % "3.8.0"
)

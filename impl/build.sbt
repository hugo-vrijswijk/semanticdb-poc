name := "semanticdb-poc"

version := "0.1"
ThisBuild / turbo := true
scalaVersion := "2.13.0"
lazy val scalametaV = "4.2.0"
libraryDependencies ++= Seq(
  "org.scalameta" %% "scalameta" % scalametaV,
  "com.github.pathikrit" %% "better-files" % "3.8.0"
)

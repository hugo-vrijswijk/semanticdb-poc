scalaVersion := "2.13.0"
addCompilerPlugin(
  "org.scalameta" % "semanticdb-scalac" % "4.2.1" cross CrossVersion.full
)
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
ThisBuild / turbo := true
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := "4.2.1"
ThisBuild / semanticdbIncludeInJar := false

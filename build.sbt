ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "CodingTestScala"
  )

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.2"
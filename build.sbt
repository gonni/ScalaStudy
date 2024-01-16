ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "CodingTestScala"
  )

libraryDependencies ++= Seq(
  "dev.zio"       %% "zio"                 % "2.0.19",
  "dev.zio"       %% "zio-streams"          % "2.0.13",
  "dev.zio"       %% "zio-json"            % "0.6.2",
  "dev.zio"       %% "zio-http"            % "3.0.0-RC2",
  "io.getquill"   %% "quill-zio"           % "4.8.0",
  "io.getquill"   %% "quill-jdbc-zio"      % "4.8.0",
  "com.h2database" % "h2"                  % "2.2.224",
  "mysql" % "mysql-connector-java" % "8.0.28",
  "dev.zio"       %% "zio-config"          % "4.0.0-RC16",
  "dev.zio"       %% "zio-config-typesafe" % "4.0.0-RC16",
  "dev.zio"       %% "zio-config-magnolia" % "4.0.0-RC16"
)

libraryDependencies += "org.typelevel" %% "cats-core" % "2.7.0"
//libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.2"

scalacOptions ++= Seq(
  "-language:higherKinds"
)
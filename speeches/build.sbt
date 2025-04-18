ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "speeches",
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.tapir" %% "tapir-core" % "1.11.24",
      "com.softwaremill.sttp.tapir" %% "tapir-netty-server" % "1.11.24",
      "com.softwaremill.sttp.tapir" %% "tapir-netty-server-sync" % "1.11.24",
      "com.softwaremill.sttp.tapir" %% "tapir-files" % "1.11.24",
    )
  )

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

enablePlugins(ScalaJSPlugin)

scalaJSUseMainModuleInitializer := true

lazy val root = (project in file("."))
  .settings(
    name := "indexView",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.8.0",
      "com.raquo" %%% "laminar" % "17.2.0",
      "com.lihaoyi" %% "os-lib" % "0.11.4",
    )
  )

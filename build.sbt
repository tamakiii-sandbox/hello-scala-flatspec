val scala3Version = "3.4.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "hello-scala-flatspec",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "javax.servlet" % "javax.servlet-api" % "4.0.1",
      "org.scalameta" %% "munit" % "1.0.0" % Test,
      "org.scalatest" %% "scalatest" % "3.2.19" % Test,
      "org.scalatestplus" %% "mockito-5-12" % "3.2.19.0" % Test
    )
  )

import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
  lazy val circe = Seq(
    "io.circe" %% "circe-core" % "0.12.0-M3",
    "io.circe" %% "circe-generic" % "0.12.0-M3",
    "io.circe" %% "circe-parser" % "0.12.0-M3"
  )
}

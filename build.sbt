ThisBuild / organization := "com.struong"
ThisBuild / scalaVersion := "2.13.5"

val kindProjectorV = "0.13.2"

addCompilerPlugin(
  "org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full
)
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
)

lazy val root = (project in file(".")).settings(
  Seq(
    libraryDependencies ++= Seq(
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
      "ch.qos.logback" % "logback-classic" % "1.4.7",
      "com.github.fd4s" %% "fs2-kafka" % "3.2.0"
    )
  )
)

sbtPlugin := true

organization := "com.ssachtleben"

name := """sbt-test"""

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.4"

scalacOptions += "-feature"

resolvers ++= Seq(
  "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
  Resolver.sonatypeRepo("snapshots"),
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/",
  Resolver.mavenLocal
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.0.1")

scriptedSettings

scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }
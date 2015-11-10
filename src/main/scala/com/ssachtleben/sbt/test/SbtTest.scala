package com.ssachtleben.sbt.test

import sbt._
import sbt.Keys._
import com.typesafe.sbt.jse.SbtJsTask
import com.typesafe.sbt.web.pipeline.Pipeline

object Import {

  val sbttest = TaskKey[Pipeline.Stage]("sbttest", "Testing pipeline")

}

object SbtTest extends AutoPlugin {

  override def requires = SbtJsTask

  override def trigger = AllRequirements

  val autoImport = Import

  import autoImport._

  override def projectSettings = Seq(
    sbttest := runTest.value
  )

  private def runTest: Def.Initialize[Task[Pipeline.Stage]] = Def.task {
    streams.value.log.info("Running sbt-test")
    mappings => mappings
  }

}

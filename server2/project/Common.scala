import play.sbt.PlayImport.specs2
import sbt.Keys._
import sbt._

object Common {
  val commonSettings: Seq[Setting[_]] = Seq(
    organization  := "com.hemea",
    version       := "1.0-SNAPSHOT",
    scalaVersion  := "2.13.11",
    updateOptions := updateOptions.value.withCachedResolution(true),
    libraryDependencies ++= Seq(
      specs2                    % Test,
      "com.softwaremill.diffx" %% "diffx-specs2" % "0.3.30" % Test,
    ),
    // Required by ScalikeJDBC as of Play 3.0
    libraryDependencySchemes += "org.scala-lang.modules" %% "scala-parser-combinators" % "always",
    // Workarond ai.x.play-json-extensions , unmaintained
    excludeDependencies ++= Seq(
      // As of Play 3.0, groupId has changed to org.playframework; exclude transitive dependencies to the old artifacts
      ExclusionRule(organization = "com.typesafe.play")
    ),
    scalacOptions ++= Seq(
      "-unchecked",
      "-explaintypes",
      "-deprecation",
      "-feature",
      "-Xcheckinit",
      "-Ywarn-unused:imports",
      "-Xfatal-warnings",
      "-Xlint:adapted-args,inaccessible",
      "-Ywarn-dead-code",
    ),
    Compile / console / scalacOptions --= Seq(
      "-Ywarn-unused:imports",
      "-Xfatal-warnings",
    ), // fix false positive in console
    // désactive génération scaladoc
    Compile / doc / sources                := Seq.empty,
    Compile / packageDoc / publishArtifact := false,
    // Useful to loop over a flaky test. Possible to tweak it with "project common;testOnly *ExampleSpec" instead of "test"
    commands += Command.command("testUntilFailed") { state => "test" :: "testUntilFailed" :: state },
  )

  val subModuleSettings: Seq[sbt.Setting[_]] = commonSettings ++ Seq(
    Compile / scalaSource       := baseDirectory.value / "src",
    Test / scalaSource          := baseDirectory.value / "test",
    Compile / resourceDirectory := baseDirectory.value / "src" / "resources",
    Test / resourceDirectory    := baseDirectory.value / "test" / "resources",
    Test / javaOptions += s"-Dconfig.file=${baseDirectory.value}/../../conf/test.conf",
  )

  val bffSubmoduleSettings: Seq[sbt.Setting[_]] = commonSettings ++ Seq(
    Compile / scalaSource := baseDirectory.value / "src",
    Test / javaOptions += s"-Dconfig.file=${baseDirectory.value}/../../conf/test.conf",
  )
}

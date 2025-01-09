import play.sbt.routes.RoutesKeys
import sbt.Keys.{javaOptions, libraryDependencies}

name := "hemea-api"

libraryDependencies += "io.sentry" % "sentry" % "7.4.0"
libraryDependencies += guice

// In dev mode, play http server starts before parsing application.conf
PlayKeys.devSettings := Seq("play.server.max-header-size" -> "64k")

// In IntelliJ the name and the ID of the root project must be the same to avoid some bugs
lazy val `hemea-api` = (project in file("."))
  .settings(
    Common.commonSettings,
    libraryDependencies ++= Seq(
      "org.flywaydb"    %% "flyway-play"      % "7.17.0",
      specs2             % "it,test",
      "org.scalikejdbc" %% "scalikejdbc-test" % Dependencies.scalikejdbcVersion % "it,test",
      "io.sentry"        % "sentry-logback"   % "7.4.0",
    ),
    Test / javaOptions += s"-Dconfig.file=${baseDirectory.value}/conf/test.conf",
    stage / aggregate  := false,
    update / aggregate := false,
  )
  .enablePlugins(PlayScala, PlayNettyServer)
  .aggregate(
    bffclient,
    devis,
  )
  .dependsOn(
    bffclient
  )

lazy val bffclient = (project in file("bff/client"))
  .settings(
    Common.bffSubmoduleSettings,
    libraryDependencies ++= Dependencies.playJson,
    RoutesKeys.routesImport -= "controllers.Assets.Asset", // fix unused import in play routes
    name := "bffclient",
  )
  .enablePlugins(PlayScala)
  .dependsOn(devis)

lazy val devis = (project in file("domain/devis"))
  .settings(
    Common.subModuleSettings,
    libraryDependencies ++= Dependencies.database,
    libraryDependencies ++= Dependencies.playJson,
    libraryDependencies ++= Dependencies.enumeratum,
    name := "devis",
  )

// align akka versions (alpakka/play)
ThisBuild / dependencyOverrides ++= Seq(
  "org.apache.pekko" %% "pekko-http"      % "1.0.1",
  "org.apache.pekko" %% "pekko-http-core" % "1.0.1",
  "org.apache.pekko" %% "pekko-http-xml"  % "1.0.1",
)

// garder la ligne suivante pour éviter des outofmemoryerror dans sbt
ThisBuild / fork               := true
ThisBuild / testForkedParallel := true

import play.sbt.PlayImport.jdbc
import sbt.*

object Dependencies {

  val scalikejdbcVersion = "4.2.0"
  val playJsonVersion    = "3.0.2"
  val enumeratumVersion  = "1.8.0"

  val database = Seq(
    jdbc,
    "org.postgresql"   % "postgresql"                     % "42.7.1",
    "org.scalikejdbc" %% "scalikejdbc"                    % scalikejdbcVersion,
    "org.scalikejdbc" %% "scalikejdbc-config"             % scalikejdbcVersion,
    "org.scalikejdbc" %% "scalikejdbc-play-dbapi-adapter" % "3.0.0-scalikejdbc-4.2",
  )

  val bcrypt = "org.mindrot" % "jbcrypt" % "0.4"

  val playJson = Seq(
    "org.playframework" %% "play-json" % playJsonVersion,
    "ai.x" %% "play-json-extensions" % "0.42.0", // <=== Abandonned . Uses internals like there is no tomorrow
    // And Scala dropped them after 2.13.11 . Needs replacement or fork, or wait until this fork
    // is eventually merged and stable. https://github.com/Particeep/play-json-extensions
    // "com.parteceep" %% "play-json-extensions" % "0.43.1",
  )

  val enumeratum = Seq(
    "com.beachape" %% "enumeratum-play"      % enumeratumVersion,
    "com.beachape" %% "enumeratum-play-json" % enumeratumVersion,
  )
}

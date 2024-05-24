import scalanative.build.Mode

enablePlugins(ScalaNativePlugin)

name := "scala.native.nginx"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.4.2" // Use latest release!
libraryDependencies ++= {
  Seq(
    "com.github.lolgab" %%% "snunit" % "0.9.0",
    "com.softwaremill.sttp.client4" %%% "core" % "4.0.0-M14",
    "org.ekrich" %%% "sjavatime" % "1.1.9",
    "org.scalatest" %%% "scalatest" % "3.2.18" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
nativeConfig ~= {
  _.withMode(Mode.releaseFast)
}

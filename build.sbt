import scalanative.build.Mode

enablePlugins(ScalaNativePlugin)

name := "scala.native.nginx"
organization := "objektwerks"
version := "0.3-SNAPSHOT"
scalaVersion := "3.6.2"
libraryDependencies ++= {
  Seq(
    "com.github.lolgab" %%% "snunit" % "0.10.2",
    "com.softwaremill.sttp.client4" %%% "core" % "4.0.0-M19",
    "org.ekrich" %%% "sjavatime" % "1.3.0",
    "org.scalatest" %%% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wall"
)
nativeConfig ~= {
  _.withMode(Mode.releaseFast)
}

import scalanative.build.Mode

enablePlugins(ScalaNativePlugin)

name := "scala.native.nginx"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.1"
libraryDependencies ++= {
  Seq(
    "com.github.lolgab" %%% "snunit" % "0.7.2",
    "com.github.lolgab" %%% "snunit-async" % "0.1.1",
    "com.softwaremill.sttp.client4" % "core_native0.4_3" % "4.0.0-M4",
    "org.ekrich" %%% "sjavatime" % "1.1.9",
    "org.scalatest" %%% "scalatest" % "3.2.16" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
nativeLinkStubs := true
nativeConfig ~= {
  _.withMode(Mode.releaseFast)
}
nativeLinkingOptions ++= Seq(
  "-L/opt/homebrew/lib"
)

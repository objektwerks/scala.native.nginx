import scalanative.build.Mode

enablePlugins(ScalaNativePlugin)

name := "scala.native.nginx"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.4.2-RC1"
libraryDependencies ++= {
  Seq(
    "com.github.lolgab" %%% "snunit" % "0.8.0",
    "com.softwaremill.sttp.client4" % "core_native0.4_3" % "4.0.0-M12",
    "org.ekrich" %%% "sjavatime" % "1.3.0",
    "org.scalatest" %%% "scalatest" % "3.2.18" % Test
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

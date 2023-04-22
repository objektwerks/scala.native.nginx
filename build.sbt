import scalanative.build.Mode

enablePlugins(ScalaNativePlugin)

name := "scala.native.nginx"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.0-RC4"
libraryDependencies ++= {
  Seq(
    "com.github.lolgab" %%% "snunit_native0.4_3" % "0.5.1",
    "com.github.lolgab" %%% "snunit-async_native0.4_3" % "0.1.1",
    ("com.github.lolgab" %%% "snunit-routes_native0.4_2.13" % "0.0.25").cross(CrossVersion.for3Use2_13),
    "org.ekrich" %%% "sjavatime" % "1.1.9",
    "org.scalatest" %%% "scalatest" % "3.2.15" % Test
  )
}
nativeLinkStubs := true
nativeConfig ~= {
  _.withMode(Mode.releaseFast)
}
nativeLinkingOptions ++= Seq(
  "-L/opt/homebrew/lib"
)
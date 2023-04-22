import scalanative.build.Mode

enablePlugins(ScalaNativePlugin)

name := "scala.native.nginx"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.0-RC4"
libraryDependencies ++= {
  val snunitVersion = "0.4.0"
  Seq(
    "com.github.lolgab" %%% "snunit" % snunitVersion,
    "com.github.lolgab" %%% "snunit-async" % snunitVersion,
    "com.github.lolgab" %%% "snunit-routes" % snunitVersion,
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

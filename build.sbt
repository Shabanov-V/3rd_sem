name := "sbtTest"

version := "1.0"

scalaVersion := "2.11.4"

resolvers += "Sonatype OSS Snapshots" at
  "https://oss.sonatype.org/content/repositories/releases"


libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.7"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.1"

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

parallelExecution in Test := false
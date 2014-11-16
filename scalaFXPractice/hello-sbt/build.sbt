// Name of the project
name := "Hello SBT"

//Project Version
version := "1.0"

// Version of Scala used by the project
scalaVersion := "2.11.2"

scalacOptions += "-target:jvm-1.7"

// Add dependecy on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.20-R6"

// Add dependency on JavaFX library based on JAVA_HOME variable
unmanagedJars in Compile += Attributed.blank(file(System.getenv("JAVA_HOME") + "/jre/lib/jfxrt.jar"))
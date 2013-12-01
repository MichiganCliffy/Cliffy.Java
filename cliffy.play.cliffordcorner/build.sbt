name := "cliffordcorner"

version := "1.0-SNAPSHOT"

resolvers += (
    "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
)

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "cliffy.common" % "cliffy.common" % "0.0.1-SNAPSHOT",
  "cliffy.data" % "cliffy.data" % "0.0.1-SNAPSHOT"
)     

play.Project.playJavaSettings

name := "salatauth"

description := "Lift Salat authentication and authorization module"

organization := "net.liftmodules"

version := "1.1-SNAPSHOT"

licenses += ("Apache 2.0 License", url("http://www.apache.org/licenses/LICENSE-2.0"))

homepage := Some(url("http://github.com/limansky/lift-salatauth"))

liftVersion <<= liftVersion ?? "2.5.1"

liftEdition <<= liftVersion apply { _.substring(0,3) }

moduleName <<= (name, liftEdition) { (n, e) => n + "_" + e }

scalaVersion := "2.10.3"

crossScalaVersions := Seq("2.9.2")

resolvers += "CB Central Mirror" at "http://repo.cloudbees.com/content/groups/public"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies <+= liftVersion { v =>
  "net.liftweb"     %% "lift-webkit"    % v         % "provided"
}

libraryDependencies ++= Seq(
  "org.mindrot"     %  "jbcrypt"        % "0.3m"    % "compile",
  "com.novus"       %% "salat"          % "1.9.5"   % "provided",
  "org.scalatest"   %% "scalatest"      % "1.9.2"   % "test"
)

scalariformSettings

publishMavenStyle := true

publishArtifact in Test := false

scmInfo := Some(
  ScmInfo(
    url("https://github.com/limansky/lift-salatauth"),
    "scm:git:https://github.com/limansky/lift-salatauth.git",
    Some("scm:git:git@github.com:limansky/lift-salatauth.git")
  )
)

publishTo := {
  val nexus = "http://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <developers>
    <developer>
      <id>limansky</id>
      <name>Mike Limansky</name>
      <url>http://github.com/limansky</url>
    </developer>
  </developers>)

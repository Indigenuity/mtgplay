name := """mtgplay"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
 	javaJdbc,
  	javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"), 
  	"org.hibernate" % "hibernate-entitymanager" % "4.3.0.Final",
  	"org.hibernate" % "hibernate-envers" % "4.3.0.Final",
  	cache,
  	javaWs,
  	"org.jsoup" % "jsoup" % "1.8.2",
  	"commons-io" % "commons-io" % "2.4",
  	"org.apache.commons" % "commons-csv" % "1.1",
  	"mysql" % "mysql-connector-java" % "5.1.35",
  	"commons-beanutils" % "commons-beanutils" % "1.9.2"
)


fork in run := true
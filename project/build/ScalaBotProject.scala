import sbt._

class ScalaBotProject(info: ProjectInfo) extends DefaultProject(info) {
  val specs = "org.scala-tools.testing" % "specs_2.8.0" % "1.6.5"
}

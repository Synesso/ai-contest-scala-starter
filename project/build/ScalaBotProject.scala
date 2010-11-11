import sbt._

class ScalaBotProject(info: ProjectInfo) extends DefaultProject(info) {
  val specs = "org.scala-tools.testing" % "specs_2.8.0" % "1.6.5"


  def zip = {
    // todo ...
    /*
rm -rf deployable
mkdir deployable
cd deployable
for f in `find ../src/snorebot/ -name "*.java"`; do grep -v "package" $f | grep -v "deleteMe"  > `echo $f | cut -d'/' -f4`; done
mkdir classes
mkdir zip
jar cvMf zip/snoreBot.zip *.java
javac -d classes *.java


     */

    
  }
}
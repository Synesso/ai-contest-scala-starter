package aicontest

object Parser {
  def parse(lines: Seq[String]) = {
    val planetsWithoutFleets = lines.flatMap(parsePlanet)
    val fleets = lines.flatMap(parseFleet)
    val planets = planetsWithoutFleets.reverse.zipWithIndex.map(p => withFleets(p, fleets))
    planets
  }
  def parse(asOneString: String): Seq[Planet] = parse(asOneString.split("\n"))

  def stripComment(line: String) = if (line.contains('#')) line.substring(0, line.indexOf('#')).trim else line.trim

  def parsePlanet(line: String) = {
    val words = line.split(" ")
    if ("P".equals(words(0))) {
      Some(Planet(0,
        java.lang.Double.parseDouble(words(1)),
        java.lang.Double.parseDouble(words(2)),
        OwnedBy(words(3)),
        java.lang.Integer.parseInt(words(4)),
        java.lang.Integer.parseInt(words(5)),
        Nil))
    } else None
  }

  def parseFleet(line: String) = {
    val words = line.split(" ")
    if ("F".equals(words(0))) {
      Some(Fleet(
        OwnedBy(words(1)),
        java.lang.Integer.parseInt(words(2)),
        java.lang.Integer.parseInt(words(4)),
        java.lang.Integer.parseInt(words(6))))
    } else None
  }

  def withFleets(planet: (Planet, Int), fleets: Seq[Fleet]) = {
    planet._1.copy(fleets=fleets.filter(_.destination == planet._2), index=planet._2)
  }
}
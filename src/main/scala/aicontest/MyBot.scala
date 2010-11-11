package aicontest

import io.Source

object MyBot extends Application {
  def parseTurnState(lines: Iterator[String]) = {
    def parse(strings: List[String]): Seq[Planet] = {
      val line = lines.next
      if ("go".equals(line)) Parser.parse(strings) else parse(line :: strings)
    }
    parse(Nil)
  }
  val bot = new YourFancyBot()
  val source = Source.fromInputStream(System.in)
  try {
    while (true) {
      val turnState = parseTurnState(source.getLines)
      val orders = bot.respondTo(turnState)
      orders.map(_.inServerSpeak).foreach(println)
      println("go")
    }
  } catch {
    case t => Log.debug(t)
  }
}
package aicontest

import java.io.{FileWriter, BufferedWriter}
import java.util.Date

object Log {
  val writer = new BufferedWriter(new FileWriter("bot.log"))

  def debug(t: Throwable): Unit = {
    debug(t.getMessage)
    t.getStackTrace.foreach(debug)
  }
  def debug(any: Any): Unit = debug(String.valueOf(any))
  def debug(msg: String) = {
    writer.write("%s: %s\n".format(now, msg))
    writer.flush
  }
  val formatter = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS")
  def now = formatter.format(new Date)

}
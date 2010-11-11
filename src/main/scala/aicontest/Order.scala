package aicontest

case class Order(from: Planet, to: Planet, quantity: Int) {
  def inServerSpeak = "%d %d %d".format(from.index, to.index, quantity);
}
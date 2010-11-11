package aicontest

trait Bot {
  def respondTo(turnState: Seq[Planet]): Set[Order]
}
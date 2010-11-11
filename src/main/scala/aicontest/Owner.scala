package aicontest

sealed trait Owner
case object Me extends Owner
case object Him extends Owner
case object Nobody extends Owner

object OwnedBy {
  def apply(s: String) = {
  s match {
      case "0" => Nobody
      case "1" => Me
      case _ => Him
    }
  }
}


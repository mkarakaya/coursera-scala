package exercise

/**
  * example for maps
  */
object polynomials {

  def main(args: Array[String]): Unit = {
    val p1 = new Poly(1 -> 2.0, 3-> 4.0, 5 -> 6.2)
    val p2 = new Poly(Map(0 -> 3.0, 3-> 7.0))
    val sum = p1 + p2
    println(sum)
  }

}

class Poly(val terms0: Map[Int, Double]) {
  def this(bindings:(Int, Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue 0.0
  def + (other: Poly) = {
    new Poly(terms ++ (other.terms map adjust) )
  }

  def adjust(term: (Int, Double)): (Int, Double) = {
    val(exp, coeff) = term
    terms get exp match {
      case Some(coeff1) => exp -> (coeff + coeff1)
      case None => exp -> coeff
    }
  }
}

package exercise
import forcomp.Anagrams._
object Exercise2 {
  def main(args: Array[String]): Unit = {
    val abba = List(('a', 2), ('b', 2))
    val a = for(
      y <- 1 to abba.length
    ) yield abba.sliding(y).toList
    println(abba)
    val b = abba.map(e => (e._1, for (
      y <- 1 to e._2
    ) yield y)).flatMap(k => List(k._1) zip k._2)

    println(b)
    val first = List(1)
    val second = List(3, 4)
    println(for(
      i <- 1 to first.length;
      j <- 1 to second.length
    ) yield (first(i-1), second(j-1)))
  }
}

object ExerciseHigherOrder {
  def main(args: Array[String]) {
    val nums = List(1, 4, 3, 4, -2, 2)
    println(squareList(nums))
    println(squareListMap(nums))
    println(nums partition (x => x > 0))
    println(nums span (x => x > 0))

    val data = List("a", "a", "a", "b", "c", "c", "a")
    println(pack(data))
    println(encode(data))

  }
  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareList(ys)
  }

  def squareListMap(xs: List[Int]): List[Int] =
    xs map (x => x * x)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span(y => y==x)
      first :: pack(rest)
  }

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))
}

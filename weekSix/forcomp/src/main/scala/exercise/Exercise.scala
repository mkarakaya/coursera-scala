package exercise

object Exercise {

  def main(args: Array[String]): Unit = {
    val xs = Array(1, 2, 3, 44)
    xs map (x => x * 2)
    println(xs.deep.mkString(","))

    val s = "Hello World"
    println(s filter(c => c.isUpper))
    println(s exists(c => c.isUpper))
    println(s forall(c => c.isUpper))

    val pairs = List(1, 2, 3) zip s
    println(pairs)
    println(pairs.unzip)

    println(s flatMap(c => List('.', c)))
    println(xs.product)
    println(isPrime(12))
    println(primePairs(7))
    val yielded = for {
      i <- 1 until 7
      j <- 1 until i
      if isPrime(i + j)
    } yield (i, j)
    println(yielded)
  }

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double = {
  //(xs zip ys).map(xy => xy._1 * xy._2).sum
    (for {
      (x, y) <- xs zip ys
    } yield x * y ).sum
  }

  def isPrime(n: Int): Boolean = (2 until n) forall(d => n % d != 0)
  def primePairs(n: Int): Seq[(Int, Int)] = {
    (1 until n).flatMap(i =>
      (1 until i) map (j => (i, j)) filter( pair =>
        isPrime(pair._1 + pair._2))
    )
  }
}

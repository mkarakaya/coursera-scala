object Exercise {

  def main(args: Array[String]) {
    val nums = List(1, 4, 3, 4, 2)
    val fruits = List("apple", "pineapple", "orange", "banana")
    println(msort(nums)((x, y) => x < y))
    println(msort(fruits)((x, y) => x.compareTo(y) <  0))
  }

  def msort[T](xs: List[T])(lt:(T, T) => Boolean): List[T] = {
    val n = xs.length/2
    if(n == 0 ) xs
    else {
      val(fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))(lt)
    }
  }

  def merge[T](xs: List[T], ys:List[T])(lt:(T, T) => Boolean): List[T]  =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (xh :: xt, yh :: yt) =>
        if(lt(xh, yh)) xh :: merge(xt, ys)(lt)
        else yh :: merge(xs, yt)(lt)

    }

}

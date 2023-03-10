/**
 * A positive integer is perfect if it equals the sum of all of its factors, excluding the number itself.
 * For example, 6, 28, 496, and so on. Define a LazyList to generate an infinite list of perfect numbers.
 * Use higher-order functions whenever possible.
 */
object perfectNumber {

  // helper function
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): LazyList[A] = f(z) match {
    case Some((h, s)) => h #:: unfold(s)(f)
    case None => LazyList()
  }

  /**
   * perfectNumber() generate an infinite list of perfect numbers.
   *
   * @return a list of perfect numbers
   */
  def perfectNumber(): LazyList[Int] = {
    unfold(2) {num =>
      if (num > 0) Some(num, num + 1)
      else None
    }.filter { num =>
      factors(num).sum == num
    }
  }

  /**
   * factors() takes an integer n and returns a LazyList of factors of n, excluding n itself.
   *
   * @param n: an integer whose factors are to find
   * @return a LazyList of factors of n
   */
    /*unchecked*/
  def factors(n: Int): LazyList[Int] = {
    unfold(1) { num =>
      if (num < n) Some(num, num + 1)
      else None
    }.filter(n%_ == 0)
  }

  def main(args: Array[String]): Unit = {
    println("First 3 perfect numbers are " + perfectNumber().take(3).toList)
    println("First 4 perfect numbers are " + perfectNumber().take(4).toList)
  }
}
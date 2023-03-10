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
    /**
     * test cases for perfectNumber()
     */

    // Initialize variables for test cases
    var n = 0
    var result: LazyList[Int] = LazyList()


    /**
     * testing for first 3 numbers
     */
    n = 3
    result = perfectNumber().take(n)
    println("First " + n + " perfect numbers are " + result.toList)

    /**
     * testing for first 4 numbers
     */
    n = 4
    result = perfectNumber().take(n)
    println("First " + n + " perfect numbers are " + result.toList)
  }
}
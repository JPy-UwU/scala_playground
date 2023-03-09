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
  def perfectNumber(): List[(Int)] = {
    // TODO: implement perfectNumber()
    List()
  }

  def main(args: Array[String]): Unit = {

  }
}
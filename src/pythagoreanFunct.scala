/**
 * A triple (x, y, z) of positive integers is pythagorean if x2 + y2 = z2. Using the functions studied in class,
 * define a function pyth which returns the list of all pythagorean triples whose components are at most a given limit.
 * For example, function call pyth(10) should return [(3, 4, 5), (4, 3, 5), (6, 8, 10), (8, 6, 10)]
 */
object pythagoreanFunct {

  // helper function
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): LazyList[A] = f(z) match {
    case Some((h, s)) => h #:: unfold(s)(f)
    case None => LazyList()
  }

  /**
   * pyth() returns the list of all pythagorean triples whose components are at most a given limit.
   *
   * @param n: an integer which stands for a limit
   * @return a list of all pythagorean triples whose components are at most a given limit
   */
  def pyth(n: Int): List[(Int, Int, Int)] = {
    // TODO: implement pyth()
    List()
  }

  def main(args: Array[String]): Unit = {
    // TODO: Add test cases
  }
}
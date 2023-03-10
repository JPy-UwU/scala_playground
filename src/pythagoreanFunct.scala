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
    val numList = unfold(1) { num =>
      if (num <= n) Some(num, num + 1)
      else None
    }

    val triples = for {
      x <- numList
      y <- numList
      z <- numList
    } yield (x, y, z)

    val pythTriples = triples.filter {
      case (x, y, z) => x*x + y*y == z*z
    }
    pythTriples.toList
  }

  def main(args: Array[String]): Unit = {

    /**
     * Test cases for pyth()
     */

    // Initializing variables for test cases
    var n: Int = 0
    var result: List[(Int, Int, Int)] = List()

    /**
     * testing with n = 0
     */

    result = pyth(n)
    println("Input: " + n)
    println("Output: " + result)

    /**
     * testing with n = 5
     */

    n = 5
    result = pyth(n)
    println("\nInput: " + n)
    println("Output: " + result)

    /**
     * testing with n = 10
     */

    n = 10
    result = pyth(n)
    println("\nInput: " + n)
    println("Output: " + result)

    /**
     * testing with n = 17
     */

    n = 17
    result = pyth(n)
    println("\nInput: " + n)
    println("Output: " + result)

  }
}
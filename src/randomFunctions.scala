object randomFunctions {

  def luhnDouble(n: Int): Int = {
    if (2*n < 9) n
    else 2*n - 9
  }

  def altMap[A, B](list1: List[A => B], list2: List[A]): List[B] = {
    def altMap_helper(n: Int, list: List[B]): List[B] = {
      if (n >= list2.length) list
      else list :+ list1(n % list1.length)(list2(n))
    }
    altMap_helper(0, List())
  }


  def main(args: Array[String]): Unit = {

  }
}
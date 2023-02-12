/**
 * This file contains functions to perform a Faro Suffle.
 * A perfect Faro shuffle breaks up the stack into two sub-stacks of exactly the same size,
 * and then combines them in the manner described above.
 * An out-shuffle results in the top and the bottom cards of the stack remaining the same after the shuffle;
 * an in-shuffle results in these cards becoming the second and the second last cards of the shuffled stack.
 */
object Main {

  /**
   * shuffle() takes two lists representing decks of cards, and returns the result of a combining of the lists.
   * Particularly, the returned list contains the first element of first list,
   * followed by the first element of second list, followed by the second element of first list, and so on.
   * If one of the lists ends before the other, the other list’s remaining elements are simply added to the end.
   *
   * @param l1: a List containing Any type of elements
   * @param l2: a List containing Any type of elements
   * @return a List which is a combination of the two lists
   */
  def shuffle(l1: List[Any], l2: List[Any]): List[Any] = {
    // TODO: complete shuffle()
    List()
  }

  /**
   * split() splits the contents of the provided list into two lists, the first with the first n elements of
   * the list (in order), and the second with the remaining elements (again, in order). These two lists are
   * then returned as a list of two lists.
   *
   * @param list: a List to split containing Any type of elements
   * @param n: an integer indicating form where to split
   * @return a List of two Lists, where each List is split from the list
   */
  def split(list: List[Any], n: Int): List[List[Any]] = {
    // TODO: complete split()
    List()
  }

  /**
   * outshuffle() takes a list with even number of elements, then splits it in half and performs a shuffle on those lists
   * as such first and last card of first list is the first and last card of shuffled list and returns the shuffled list.
   *
   * @param list: a List containing even number of elements of Any type
   * @return a shuffled List
   */
  def outshuffle(list: List[Any]): List[Any] = {
    // TODO: complete outshuffle()
    List()
  }

  /**
   * inshuffle() takes a list with even number of elements, then splits it in half and performs a shuffle on those lists
   * as such first and last card of first list is the second and second last card of shuffled list and returns the shuffled list.
   *
   * @param list : a List containing even number of elements of Any type
   * @return a shuffled List
   */
  def inshuffle(list: List[Any]): List[Any] = {
    // TODO: complete inshuffle()
    List()
  }

  /**
   * nshuffle() takes three parameters, a shuffle function (such as outshuffle or inshuffle), an integer indicating
   * how many shuffles to carry out, and a list to shuffle, which is of even length. It then carries out the required
   * number of shuffles on the list, and returns the result.
   *
   * @param shuffleType: a shuffle function (such as outshuffle or inshuffle)
   * @param n: an integer indicating how many shuffles to carry out
   * @param list: a list to shuffle, which is of even length
   * @return a List after carrying out required number of shuffle of list
   */
  def nshuffle(shuffleType: List[Any] => List[Any], n: Int ,list: List[Any]): List[Any] = {
    // TODO: complete nshuffle()
    List()
  }

  /**
   * howManyShuffles() takes three parameters: a shuffle function (such as outshuffle or inshuffle),
   * and two lists of even size.  It keeps applying the shuffle function on the first of the two lists,
   * until it becomes identical to the second list, and returns the count of the number of shuffles that were required.
   *
   * @param shuffleType: a shuffle function (such as outshuffle or inshuffle)
   * @param list1: a list of even length
   * @param list2: : a list of even length
   * @return the count of the number of shuffles that were required to make list1 identical to list2
   */
  def howManyShuffles(shuffleType: List[Any] => List[Any], list1: List[Any], list2: List[Any]): Int = {
    // TODO: complete howManyShuffles()
    -1
  }

  def main(args: Array[String]): Unit = {
    // TODO: write test cases each function

  }
}
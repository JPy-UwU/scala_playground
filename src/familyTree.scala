/**
 * This file contains functions to to extract information about particular family relationships from the given Map.
 * Consider the following slightly out-of-date Map for the British royal family,
 * showing gender and parentage information for individuals.
 * For example, the information for Prince Harry is represented using the "Harry" -> ("m", "Diana", "Charles") mapping.
 * The Map is based on an earlier version of the tree shown on this webpage:
 * https://www.bbc.com/news/uk-23272491
 */
object familyTree {
  val royalParent = Map("George" -> ("m", "William", "Catherine"), "Charlotte" -> ("f", "William", "Catherine"), "Louis" -> ("m", "William", "Catherine"), "Archie" -> ("m", "Harry", "Meghan"),  "Lilibet" -> ("f", "Harry", "Meghan"), "Savannah" -> ("f", "Autumn", "Peter"), "Isla" -> ("f", "Autumn", "Peter"), "Mia" -> ("f", "Zara", "Mike"), "Lena" -> ("f", "Zara", "Mike"), "Lucas" -> ("m", "Zara", "Mike"), "Sienna" -> ("f", "Beatrice", "Edoardo"), "August" -> ("m", "Eugenie", "Jack"), "Beatrice" -> ("f", "Andrew", "Sarah"), "Eugenie" -> ("f", "Andrew", "Sarah"), "Louise" -> ("f", "Edward", "Sophie"), "James" -> ("m", "Edward", "Sophie"), "Peter" -> ("m", "Mark", "Anne"), "Zara" -> ("f", "Mark", "Anne"), "William" -> ("m", "Diana", "Charles"), "Harry" -> ("m", "Diana", "Charles"), "Charles" -> ("m", "Elizabeth", "Philip"), "Anne" -> ("f", "Elizabeth", "Philip"), "Andrew" -> ("m", "Elizabeth", "Philip"), "Edward" -> ("m", "Elizabeth", "Philip"), "Elizabeth" -> ("f", "", ""), "Philip" -> ("m", "", ""), "Diana" -> ("f", "", ""), "Mark" -> ("m", "", ""), "Sophie" -> ("f", "", ""), "Sarah" -> ("f", "", ""), "Mike" -> ("m", "", ""), "Autumn" -> ("f", "", ""), "Meghan" -> ("f", "", ""), "Catherine" -> ("f", "", ""), "Timothy" -> ("m", "", ""), "Jack" -> ("m", "", ""), "Camilla" -> ("f", "", ""), "Edoardo" -> ("m", "", ""))

  /**
   * children() takes two parents as arguments and returns either list of children or none as option type.
   * Note: the parents can be in either order.
   *
   * @param parent1: a string containing name of a parent
   * @param parent2: a string containing name of a parent
   * @return a list of string which is of option type and has names of children inside
   */
  def children(parent1: String, parent2: String): Option[List[String]] = {
    val childrenName = royalParent.filter {
      case(_, (_, father, mother)) => (parent1 == father && parent2 == mother || parent2 == father && parent1 == mother)
    }.keys.toList

    if (childrenName.nonEmpty) Some(childrenName) else None
  }

  /**
   * grandparents() takes a name as an argument and returns either list of names of grandparents
   * or None as option type.
   *
   * @param p: a string containing a name
   * @return a list of string which is of option type and has names of grandparents inside
   */
  def grandparents(p: String): Option[List[String]] = {
    // TODO: implement grandparents()
    None
  }

  /**
   * sisters() takes a name as an argument and returns either list of names of sisters or None as option type.
   *
   * @param p: a string containing a name
   * @return a list of string which is of option type and has names of sisters inside
   */
  def sisters(p: String): Option[List[String]] = {
    // TODO: implement sisters()
    None
  }

  /**
   * firstCousins() takes a name as an argument and returns either a list of names of first cousins
   * or None as option type.
   *
   * @param p: a string containing a name
   * @return a list of string which is of option type and has names of first cousins inside
   */
  def firstCousins(p: String): Option[List[String]] = {
    // TODO: implement firstCousins()
    None
  }

  /**
   * uncles() takes a name as an argument and returns either a list of uncles or None as option type.
   * Note: Uncles as in both uncles who are brothers of a parent, and parent's sisters' spouses.
   *
   * @param p: a string containing a name
   * @return a list of string which is of option type and has names of uncles inside
   */
  def uncles(p: String): Option[List[String]] = {
    // TODO: implement uncles()
    None
  }

  /**
   * parents() takes a name as an argument and returns either a list of parents or None as option type.
   *
   * @param p: a string containing a name
   * @return a list of string which is of option type and has names of parents inside
   */
  def parents(p: String): Option[(String, String)] = {
    royalParent.get(p).map {
      case(_, father, mother) => (father, mother)
    }
  }

  /**
   * lift() returns a function which maps None to None and applies function to the contents of Some.
   *
   * @param f : a function to be applied
   * @return a function which maps None to None and applies function to the contents of Somes
   */
  def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f


  def main(args: Array[String]): Unit = {
    // TODO: Add test cases for all functions

    /**
     * test cases for each functions
     * test cases will show expected output if the function is working as intended
     * if not then it will show the expected out put and the output we get
     * test cases does not include edge cases as the program assumes that functions will be provided
     * with correct arguments everytime.
     * */

    /**
     * test cases for children()
     */

    // testing with legit names
    if (children("Harry", "Meghan") != Some(List("Lilibet", "Archie")))
      println("Error in children()")

    // testing with random names that does not exist

    if (children("Krutik", "Kumbhani") != None)
      println("Error in children()")
  }
}
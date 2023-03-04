/**
 * This file contains functions to to extract information about particular family relationships from the given Map.
 * Consider the following slightly out-of-date Map for the British royal family,
 * showing gender and parentage information for individuals.
 * For example, the information for Prince Harry is represented using the "Harry" -> ("m", "Diana", "Charles") mapping.
 * The Map is based on an earlier version of the tree shown on this webpage:
 * https://www.bbc.com/news/uk-23272491
 */
object familyTree {
  /**
   * children() takes two parents as arguments and returns either list of children or none as option type.
   * Note: the parents can be in either order.
   *
   * @param parent1: a string containing name of a parent
   * @param parent2: a string containing name of a parent
   * @return a list of string which is of option type and has names of children inside
   */
  def children(parent1: String, parent2: String): Option[List[String]] = {
    // TODO: implement children()
    None
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

  def main(args: Array[String]): Unit = {
    // TODO: Add test cases for all functions

  }
}
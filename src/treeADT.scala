/**
 * Represents a polymorphic Tree data type, where a Tree is either a Node with a left subtree, a value,
 * and a right subtree; or it is a Leaf with just a value.
 * */

object treeADT {

  // companion functions for the tree
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  /**
   * An in-order traversal of a tree visits the nodes in the order left subtree, root, right subtree.
   *
   * @param tree: a tree
   * @return a list with the contents of the tree when traversed in-order
   */
  def inOrder[A](tree: Tree[A]): List[A] = {
    // TODO: complete inOrder()
    List[A]()
  }

  /**
   * An pre-order traversal of a tree visits the nodes in the order left subtree, root, right subtree.
   *
   * @param tree : a tree
   * @return a list with the contents of the tree when traversed pre-order
   */
  def preOrder[A](tree: Tree[A]): List[A] = {
    // TODO: complete preOrder()
    List[A]()
  }

  /**
   * An post-order traversal of a tree visits the nodes in the order left subtree, root, right subtree.
   *
   * @param tree : a tree
   * @return a list with the contents of the tree when traversed post-order
   */
  def postOrder[A](tree: Tree[A]): List[A] = {
    // TODO: complete postOrder()
    List[A]()
  }

  /**
   * search() takes two arguments — a Tree and a key — and returns a boolean result based on whether the key is found in the tree.
   *
   * @param tree: a tree
   * @param key: a key to find in the tree
   * @return a boolean representing whether the key was found or not
   */
  def search[A](tree: Tree[A], key: A): Boolean = {
    // TODO: complete search()
    false
  }

  /**
   * replace() takes three arguments — a Tree t, a value before, and a value after — and returns t with
   * ALL instances of before replaced with the value after
   *
   * @param t: a tree
   * @param before: what to replace
   * @param after: what to replace with
   * @return A Tree with all instances of before replaced with the value after
   */
  def repalce[A](t: Tree[A], before: A, after: A): Tree[A] = {
    // TODO: complete replace()
    t
  }

  def Main(args: Array[String]): Unit = {
  // TODO: write testcases for

  }
}
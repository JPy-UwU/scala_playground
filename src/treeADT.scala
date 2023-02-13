
/**
 * Represents a polymorphic Tree data type, where a Tree is either a Node with a left subtree, a value,
 * and a right subtree; or it is a Leaf with just a value.
 * */

object treeADT {

  // companion functions for the tree
  sealed trait Tree[+A]

  case class Leaf[A](value: A) extends Tree[A]

  case class Branch[A](left: Tree[A], right: Tree[A], value: A) extends Tree[A]

  /**
   * An in-order traversal of a tree visits the nodes in the order left subtree, root, right subtree.
   *
   * @param tree: a tree
   * @return a list with the contents of the tree when traversed in-order
   */
  def inOrder[A](tree: Tree[A]): List[A] = tree match {
    case Leaf(value) => List(value)
    case Branch(left, right, value) =>  inOrder(left) ++ List(value) ++ inOrder(right)
  }

  /**
   * An pre-order traversal of a tree visits the nodes in the order left subtree, root, right subtree.
   *
   * @param tree : a tree
   * @return a list with the contents of the tree when traversed pre-order
   */
  def preOrder[A](tree: Tree[A]): List[A] = tree match{
    // TODO: complete preOrder()
    case Leaf(value) => List(value)
    case Branch(left, right, value) => preOrder(left) ++ preOrder(right) ++ List(value)
  }

  /**
   * An post-order traversal of a tree visits the nodes in the order left subtree, root, right subtree.
   *
   * @param tree : a tree
   * @return a list with the contents of the tree when traversed post-order
   */
  def postOrder[A](tree: Tree[A]): List[A] = tree match {
    // TODO: complete postOrder()
    case Leaf(value) => List(value)
    case Branch(left, right, value) => postOrder(left) ++ postOrder(right) ++ List(value)
  }

  /**
   * search() takes two arguments — a Tree and a key — and returns a boolean result based on whether the key is found in the tree.
   *
   * @param tree: a tree
   * @param key: a key to find in the tree
   * @return a boolean representing whether the key was found or not
   */
  def search[A](tree: Tree[A], key: A): Boolean = tree match {
    // TODO: complete search()
    case Leaf(value) => value == key
    case Branch(left, right, value) => search(left, key) || search(right, key)
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
  def replace[A](t: Tree[A], before: A, after: A): Tree[A] = t match {
    case Leaf(value) => if (value == before) Leaf(after) else Leaf(before)
    case Branch(left, right, value) => Branch(replace(left, before, after), replace(right, before, after), value)
  }

  def main(args: Array[String]): Unit = {
    // TODO: write testcases for


  }
}
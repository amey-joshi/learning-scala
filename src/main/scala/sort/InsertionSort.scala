import scala.collection.immutable.List

// This class has to be in a separate directory because the List used here
// tends to be eclipsed by the list we created for demonstration purpose
// in the parent directory.

object IsortTest extends App {
  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x >= y) x :: xs else y :: insert(x, ys)
  }

  def isort(L: List[Int]): List[Int] = L match {
    case List() => List()
    case x :: xs => insert(x, isort(xs))
  }

  val L = List(3, 5, 1, 0, 8, 4, 6, 9, 7)
  val Ls = isort(L)
  println(Ls)
}


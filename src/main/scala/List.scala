import scala.language.postfixOps

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.head")
}

object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T](x1: T): List[T] = new Cons(x1, new Nil)
  def apply[T](): List[T] = new Nil
}

object ListTest extends App {
  val L1 = List()
  val L2 = List(1)
  val L3 = List(1, 2)

  show(L1)
  show(L2)
  show(L3)

  def show[T](L: List[T]) = {
    var M = L
    while (!(M isEmpty)) {
      print(M.head + " ")
      M = M tail
    }
    println("nil")
  }
}

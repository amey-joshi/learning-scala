trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Product(e1, e2) => e1.eval * e2.eval
  }

  def show: String = this match {
    case Number(n) => n.toString
    case Sum(e1, e2) => s"(${e1.show} + ${e2.show})"
    case Product(e1, e2) => s"(${e1.show} * ${e2.show})"
  }
}

case class Number(val n: Int) extends Expr {
  def numValue = n
  def leftOp = throw new Error("Number.leftOp")
  def rightOp = throw new Error("Number.rightOp")
}

case class Sum(val e1: Expr, val e2: Expr) extends Expr {
  def numValue = throw new Error("Sum.numValue")
  def leftOp = e1
  def rightOp = e2
}

case class Product(val e1: Expr, val e2: Expr) extends Expr {
  def numValue = throw new Error("Product.numValue")
  def leftOp = e1
  def rightOp = e2
}

object ExprTest extends App {
  val e1 = Sum(Number(3), Number(4))
  val e2 = Sum(Number(5), e1)
  val e3 = Product(e1, e2)

  println(s"${e1.show} = ${e1.eval}")
  println(s"${e2.show} = ${e2.eval}")
  println(s"${e3.show} = ${e3.eval}")
}


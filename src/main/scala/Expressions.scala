trait Expr {
  // Methods to identify
  def isNumber: Boolean
  def isSum: Boolean
  def isProduct: Boolean

  // Methods to access data
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr

  def eval: Int = {
    if(isNumber)
      numValue
    else if(isSum)
      leftOp.eval + rightOp.eval
    else if(isProduct)
      leftOp.eval * rightOp.eval
    else
      throw new Error("Parse error.")
  }
}

class Number(val n: Int) extends Expr {
  def isNumber = true
  def isSum = false
  def isProduct = false

  def numValue = n
  def leftOp = throw new Error("Number.leftOp")
  def rightOp = throw new Error("Number.rightOp")
}

class Sum(val e1: Expr, val e2: Expr) extends Expr {
  def isNumber = false
  def isSum = true
  def isProduct = false

  def numValue = throw new Error("Sum.numValue")
  def leftOp = e1
  def rightOp = e2
}

class Product(val e1: Expr, val e2: Expr) extends Expr {
  def isNumber = false
  def isSum = false
  def isProduct = true

  def numValue = throw new Error("Product.numValue")
  def leftOp = e1
  def rightOp = e2
}

object ExprTest extends App {
  val e1 = new Sum(new Number(3), new Number(4))
  val e2 = new Sum(new Number(5), e1)
  val e3 = new Product(e1, e2)

  println(s"e1 = ${e1.eval}")
  println(s"e2 = ${e2.eval}")
  println(s"e3 = ${e3.eval}")
}


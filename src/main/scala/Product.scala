object Product {
  def eval(f: Int => Int, a: Int, b: Int) = {
    def evaluator(acc: Int, a: Int): Int = {
      if (a > b) acc
      else acc * evaluator(f(a), a + 1)
    }

    evaluator(1, a)
  }
}

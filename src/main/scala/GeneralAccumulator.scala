object GeneralAccumulator {
  /**
    * Recursively evaluates the accumulator. It computes g(f(n), g(f(n-1), g( ... ))) where n ranges from a to b.
    *
    * If g is the addition operator, then it computes +(f(b), +(f(b - 1), +( ... ))) = f(b) + f(b - 1) + ... + f(a).
    * Likewise, if g is the multiplication operator then it computes the product f(a) * f(a + 1) * ... * f(b).
    *
    * @param f the transformation on an individual element.
    * @param g a binary operation on elements
    * @param a the first element
    * @param b the last element
    * @param e an identity suitable for the binary operator 'g'.
    * @return the result of accumulation.
    */
  def eval(f: Int => Int, g: (Int, Int) => Int, a: Int, b: Int, e: Int): Int = {
    def evaluator(acc: Int, a: Int): Int = {
      if (a > b) acc
      else g(acc, evaluator(f(a), a + 1))
    }

    evaluator(e, a)
  }
}

object Factorial {
  // Finding factorials with tail recursion so that the calls can be optimized.
  def FactTR(accumulator: Int, n: Int): Int = {
    if (n == 0) accumulator
    else FactTR(accumulator * n, n - 1)
  }

  def eval(n: Int) = {
    if (n >= 0) FactTR(1, n)
    else throw new IllegalArgumentException("Cannot find factorial of negative number.")
  }
}

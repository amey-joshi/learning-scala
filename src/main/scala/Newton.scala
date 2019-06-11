object Newton {
  // How to use this class?
  // Load this file on the scala prompt using :load command.
  // Use it as Newton.sqrt(2.0).

  def sqrt(x: Double) = {
    import math.abs

    val EPSILON = 1e-6
    val EPSILON_SQRT = 1e-12

    def isGoodEnough(guess: Double) = if (x > 0) abs(guess * guess - x) / x < EPSILON else guess < EPSILON_SQRT

    def improve(guess: Double) = (guess + x / guess) * 0.5

    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else (sqrtIter(improve(guess)))
    }

    if (x > 0)
      sqrtIter(1.0)
    else
      throw new IllegalArgumentException("Cannot find square roots of negative reals.")
  }
}

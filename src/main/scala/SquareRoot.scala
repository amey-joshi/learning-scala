object SquareRoot {
  /**
    * Finds square root of a positive real number.
    *
    * @param y a positive real number.
    *
    * @return square root of y.
    */
  def find(y: Double): Double = {
    import math.abs
    val EPSILON = 1E-6
    val SQRT_EPSILON = 1E-12

    def isGoodEnough(x: Double) = if (y > 0) (abs(x*x - y)/y) < EPSILON else abs(x*x) < SQRT_EPSILON
    def improve(x: Double) = (x + y/x)*0.5

    def iterate(x: Double): Double = {
      if (isGoodEnough(x)) x
      else iterate(improve(x))
    }

    if (y >= 0)
      iterate(1)
    else
      throw new IllegalArgumentException("Cannot find square roots of negative numbers.")
  }
}

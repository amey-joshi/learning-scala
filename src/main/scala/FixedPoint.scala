object FixedPoint {
  /**
    * Finds the fixed point of a function f.
    *
    * This is the true algorithm. However, in many cases, it is numerically unstable if used directly. Therefore, if
    * g is the function whose fixed point is sought, we find the fixed point of f(x) = (x + g(x))/2.
    *
    * @param f a real valued function of real numbers.
    * @param guess an initial guess of the fixed point.
    * @return the fixed point.
    */
  private def find(f: Double => Double)(guess: Double): Double = {
    import math.abs

    val EPSILON = 1e-6

    def isGoodEnough(x: Double) = abs(x - f(x))/x < EPSILON
    def improve(x: Double) = f(x)

    def iterate(x: Double): Double = {
      if (isGoodEnough(x)) x
      else iterate(improve(x))
    }

    iterate(guess)
  }

  /**
    * Gets the average of x and f(x).
    *
    * @param f a real valued function of real numbers.
    * @param x a real number.
    * @return (x + f(x))/2
    */
  private def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2

  /**
    * Get fixed point of a function f starting with a guess.
    *
    * @param f a real valued function of real numbers.
    * @param guess an initial guess of the fixed point of x.
    * @return the fixed point of f.
    */
  def get(f: Double => Double)(guess: Double): Double = find(averageDamp(f))(guess)
}

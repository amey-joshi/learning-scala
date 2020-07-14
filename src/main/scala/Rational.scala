class Rational(n: Int, d: Int = 1) {
  require(d != 0)

  def this(n: Int) = this(n, 1) // Integers are rational numbers.

  // Having a private field g saves the computation of gcd twice.
  // The compiler does *not* optimise by calculating the common sub-
  // expression only once.
  private val g: Int = gcd(n.abs, d.abs)
  val num: Int = d.sign * n / g // The numerator.
  val den: Int = d.sign * d / g // The denominator.

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String = if (den != 1) s"$num/$den" else s"$num"

  // Algebraic operators
  def unary_- = new Rational(-num, den)

  def +(z: Rational): Rational =
    new Rational(num * z.den + den * z.num, den * z.den)

  // Do not define this method as 
  // this + (-z)
  // It creates a new object -z that serves no purpose.
  def -(z: Rational): Rational = 
    new Rational(num * z.den + den * z.num, den * z.den)

  def *(z: Rational): Rational = 
    new Rational(num * z.num, den * z.den)

  def /(z: Rational): Rational =
    if (z.num != 0) new Rational(num * z.den, den * z.num)
    else throw new IllegalAccessException("Attempting to divide by zero.")

  // Overloaded methods
  def +(n: Int) = new Rational(num + n*den, den)
  def -(n: Int) = new Rational(num - n*den, den)
  def *(n: Int) = new Rational(n * num, den)
  def /(n: Int) = new Rational(num, n * den)

  // Comparison operators
  def <(z: Rational): Boolean = num * z.den < den * z.num

  override def equals(z: Any): Boolean = 
    z.isInstanceOf[Rational] &&
    num == z.asInstanceOf[Rational].num && 
    den == z.asInstanceOf[Rational].den

  def <=(z: Rational): Boolean = this < z || (this equals z)

  def >=(z: Rational): Boolean = this > z || (this equals z)

  def >(z: Rational): Boolean = !(z < this && (z equals this))
}

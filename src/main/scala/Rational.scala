class Rational(n: Int, d: Int = 1) {
  require(d != 0)
  import math.abs
  import math.signum

  val numerator: Int = signum(d) * n/gcd(abs(n), abs(d))
  val denominator: Int = signum(d) * d/gcd(abs(n), abs(d))

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String = numerator + "/" + denominator

  // Algebraic operators
  def unary_- = new Rational(-this.numerator, this.denominator)
  def +(that: Rational): Rational =
    new Rational(this.numerator * that.denominator + this.denominator * that.numerator, this.denominator * that.denominator)
  def -(that: Rational): Rational = this + (-that)
  def *(that: Rational): Rational = new Rational(this.numerator * that.numerator, this.denominator * that.denominator)
  def /(that: Rational): Rational =
    if (that.numerator != 0) new Rational(this.numerator * that.denominator, this.denominator * that.numerator)
    else throw new IllegalAccessException("Attempting to divide by zero.")

  // Comparison operators
  def <(that: Rational): Boolean = this.numerator * that.denominator < this.denominator * that.numerator

  override def equals(that: Any): Boolean = that.isInstanceOf[Rational] &&
    this.numerator == that.asInstanceOf[Rational].numerator && this.denominator == that.asInstanceOf[Rational].denominator

  def <=(that: Rational): Boolean = this < that || (this equals that)
  def >=(that: Rational): Boolean = this > that || (this equals that)
  def >(that: Rational): Boolean = !(that < this && (that equals this))
}

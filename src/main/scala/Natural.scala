abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

class Succ(n: Nat) extends Nat {
  override def isZero = false
  override def predecessor = n
  override def successor = new Succ(this)
  override def + (that: Nat): Nat = 
    if (that.isZero) this else new Succ(this.n) + that.predecessor
  override def - (that: Nat): Nat = 
    if (that.isZero) this else this.predecessor - that.predecessor
}

object Zero extends Nat {
  override def isZero = true
  override def predecessor = null
  override def successor = new Succ(Zero)
  override def + (that: Nat) = that
  override def - (that: Nat) = 
    throw new IllegalArgumentException("Cannot subtract a number from 0.")
}

object NatTest extends App {
  if (Zero.isZero) println("Zero is 0.") else println("Zero is not 0.")
  if (Zero.predecessor == null) println("Zero has no predecessor") 
  else println("Zero has a predecessor.")
}


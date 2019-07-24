// Run this class using the command: scala NatTest

// We need this import to allow us to write x isZero instead of x.isZero
import scala.language.postfixOps

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
  override def toString = {
    var n = 0
    var obj: Nat = this
    while (obj.predecessor != null) {
      n = n + 1
      obj = obj.predecessor
    }
    n.toString
  }
}

class Succ(n: Nat) extends Nat {
  override def isZero = false
  override def predecessor = n
  override def successor = new Succ(this)
  override def + (that: Nat): Nat =
    if (that isZero) this else new Succ(this) + that.predecessor
  override def - (that: Nat): Nat = 
    if (that isZero) this else this.predecessor - that.predecessor
}

object Zero extends Nat {
  override def isZero = true
  override def predecessor = null
  override def successor = new Succ(Zero)
  override def + (that: Nat) = that
  override def - (that: Nat) = {
    if (that isZero) 
      Zero 
    else 
      throw new IllegalArgumentException("Cannot subtract a number from 0.")
  }
}

object NatTest extends App {
  val z = Zero
  val o = new Succ(z)
  val t = new Succ(o)
  val f = new Succ(new Succ(t))

  println("<<< Basic tests. >>>")
  check(z)
  check(o)
  check(t)
  check(f)

  println("<<< Checking addition. >>>")
  checkAddition(z, o)
  checkAddition(o, z)
  checkAddition(o, o)
  checkAddition(o, t)
  checkAddition(t, o)
  checkAddition(f, f)

  println("<<< Checking subtraction. >>>")
  checkSubtraction(o, z)
  checkSubtraction(o, o)
  checkSubtraction(t, o)
  checkSubtraction(f, o)
  try {
    checkSubtraction(z, o)
  } catch {
    case x: IllegalArgumentException => println(s"Cannot subtract $o from $z")
  }

  def check(n: Nat) = {
    if (n.isZero) println(s"$n == 0") else println(s"$n != 0")
    if (n.predecessor != null) println(s"has predecessor ${n.predecessor}") else println("doesn't have predecessor")
    println(s"Successor is ${n.successor}")
  }

  def checkAddition(n: Nat, m: Nat) {
    val r = n + m
    val result = s"$n + $m = $r" 
    println(result)
  }

  def checkSubtraction(n: Nat, m: Nat) {
    val r = n - m
    val result = s"$n - $m = $r" 
    println(result)
  }
}


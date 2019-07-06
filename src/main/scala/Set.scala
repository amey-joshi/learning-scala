object IntegerSets {
  // How to use this class?
  // Load the file on the scala command prompt using :load.
  // Use it as IntegerSets.contains(IntegerSets.NegativeIntegers, -5)
  //
  // Alternatively,
  // import IntegerSets._
  // contains(EvenIntegers, 8)

  type Set = Int => Boolean

  def contains(s: Set, elem: Int) = s(elem)

  def NegativeIntegers: Set = (n: Int) => n < 0
  def PositiveIntegers: Set = (n: Int) => n > 0
  def EvenIntegers: Set = (n: Int) => PositiveIntegers(n) && n % 2 == 0
  def OddIntegers: Set = (n: Int) => PositiveIntegers(n) && n % 2 == 1

  def SingletonSet(n: Int): Set = {m: Int => n == m}
  def Union(s: Set, t: Set): Set = {m: Int => contains(s, m) || contains(t, m)}
  def Intersection(s: Set, t: Set): Set = {m: Int => contains(s, m) && contains(t, m)}
  def Diff(s: Set, t: Set): Set = {m: Int => contains(s, m) && !contains(t, m)}
  def Filter(s: Set, p: Int => Boolean): Set = {m: Int => contains(s, m) && contains(p, m)}
}

/* Sample tests on scala prompt.
:load Set.scala
import IntegerSets._
val s1 = SingletonSet(1)
val s2 = SingletonSet(2)
val s3 = SingletonSet(3)
val s123 = Union(s1, Union(s2, s3))
contains(s123, 2) // should return true
contains(s123, 4) // should return false
val t = Intersection(s123, Union(SingletonSet(3), SingletonSet(4)))
contains(t, 3) // should return true
contains(t, 4) // should return false
val s12 = Diff(s123, t)
contains(s12, 1) // should return true
contains(s12, 2) // should return true
contains(s12, 3) // should return false
val r = Filter(s123, OddIntegers)
contains(r, 1) // should return true
contains(r, 2) // should return false
contains(r, 3) // should return true
contains(r, 4) // should return false
contains(r, 5) // should return false
*/

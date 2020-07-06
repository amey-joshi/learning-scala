/**
 * Build a list of integers and a map with an integer and its cube.
 *
 * 01-Jul-2020
 */
import scala.util.control.Breaks._
import scala.collection.mutable.Map

// Build a list from a range.
val L = (1 to 20).toList
val cubes = Map[Int, Int]()
// Build a map from pairs. The syntax x -> y creates a tuple (x, y).
L.map(n => n -> n * n * n).foreach(p => cubes += p)

// Scala does not have a break keyword. In order to make a look
// breakable, one needs this construct and the corresponding import
// statement.
breakable {
  while (true) {
    print("Enter a positive number, or -1 to exit: ")
    var k = scala.io.StdIn.readInt
    if (k < 1) {
      break
    } else {
      var v = cubes.getOrElse(k, -1)
      if (v > 0) {
        println(s"$k^3 = $v")
      } else {
        println("I do not have the value of the cube.")
      }
    }
  }
}



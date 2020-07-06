/**
 * A script that finds the longest line in a file and reports its length.
 *
 * 03-Jul-2020
 */
import scala.io.Source

if (args.length > 0) {   
  // The entire algorithm is described in a single line, much like a Unix shell
  // script.
  val longest = Source.fromFile(args(0)).getLines().toList.reduceLeft((a, b) => if (a.length > b.length) a else b)
  println(s"Longest line is ${longest.length} characters wide.")
} else {
  println("Error: give a file name.")
}
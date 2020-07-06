/**
 * A script similar to nl, except that it prints the length of a line
 * instead of 'line number'.
 *
 * 01-Jul-2020
 */
import scala.io.Source

if (args.length > 0) {
  val lines = Source.fromFile(args(0)).getLines().toList
  val maxWidth = lines.map(line => line.length).max.toString.length

  lines.foreach(l => printf(s"%${maxWidth}d %s\n", l.length, l))
} else {
  println("Error: give a file name.")
}


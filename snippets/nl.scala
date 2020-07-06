/**
 * A poor man's nl. It prints a file with the line number appended.
 *
 * 01-Jul-2020
 */
import scala.io.Source

if (args.length > 0) {
  val allLines = Source.fromFile(args(0)).getLines().toList
  val width = allLines.size.toString.length

  ((1 to allLines.size).toList zip allLines).
    foreach(p => printf(s"%${width}d %s\n", p._1, p._2))
} else {
  println("Error: give a file name.")
}

// https://github.com/amey-joshi/learning-scala.git

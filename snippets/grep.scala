/*
 * A script that searches a string in all scala files. This is not a 
 * full-features regular expression matcher. It just checks if a line
 * contains a pattern.
 *
 * 14-Jul-2020
 */
import java.io.File
import scala.io.Source

if (args.length > 0) {
  // We have to include the charset in the fromFile method to prevent
  // MalformedInputException.
  def lines(f: File) = Source.fromFile(f, "ISO-8859-1").getLines().toArray

  def grep(pattern: String) = {

    def printIf(f: File, l: String) = 
      if (l.contains(pattern)) println(s"$f: ${l.trim}")

    // Recall that we are using the java.io.File class. Therefore,
    // new File(".") will open this directory.
    (new File(".")).
    listFiles.
    filter(_.isFile).
    filter(_.getName.endsWith(".scala")).
    foreach(f => lines(f).foreach(l => printIf(f, l))) 
  }

  grep(args(0))
}


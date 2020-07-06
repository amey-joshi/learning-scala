/**
 * The only purpose of a checksum calculator is to return the checksum of a 
 * string of characters. Users of this facility should not be burdened with 
 * creation of a class, initializing it and choosing the right method to 
 * compute the checksum. This is where companion classes come into play.
 *
 * Therefore, the companion class just has a single method {@link #calculate
 * }. A companion class is like a singleton that need not be initialized 
 * using a factory method. It can just be used as if it were a namespace.
 *
 * 04-Jul-2020. 
 */
import scala.collection.mutable.Map

object Checksum {
  // Maps a string to its checksum.
  private val cache = Map.empty[String, Int]

  def calculate(s: String): Int = {
    if (!cache.contains(s)) {
      // How to calculate the checksum of a string?
      // Convert each character of a string to an integer, add all integers,
      // AND it with 0xFF and add one to the result. All of this is 
      // achieved in a single line. The integer 'cs' is the checksum of the
      // string 's'.
      val cs = (s.map(_.toInt).toList.sum & 0xFFFF) + 1
      
      cache += (s -> cs)
    }
      
    cache(s)
  }
}


package dbg.demo

import org.slf4j.{Logger, LoggerFactory}

object TheApp {
  def logger = LoggerFactory.getLogger(TheApp.getClass)
  
  def f(n: Int, m: Int): Int = {
    logger.info(s"n = $n, m = $m")
    
    if (n > 0 && m > 0)
      3*m + 2*n
    else if (n < 0 && m > 0) 
      4*m + 3*n
    else if (n > 0 && m < 0)
      5*m + 4*n
    else
      6*m + 5*n
  }
  
  def main(args: Array[String]) = {
    val y1 = f(3, 4)
    val y2 = f(2, -1)
    val y3 = f(-2, 1)
    val y4 = f(-2, -4)
    
    println(s"y1 = ${y1}")
    println(s"y2 = ${y2}")
    println(s"y3 = ${y3}")
    println(s"y4 = ${y4}")
  } 
}
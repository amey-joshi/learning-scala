/*
 * Prints multiplication tables.
 *
 * Code adapted from chapter 7 of Odersky's book.
 *
 * 14-Jul-2020
 */
def rowValues(r: Int) = 
  for (c <- 1 to 10) yield {
    val v = (r * c).toString
    val padding = " " * (4 - v.length)

    padding + v
  }

def tableRow(r: Int) = rowValues(r).mkString(" ")

def buildTables() = {
  val tableRows = for (r <- 1 to 10) yield tableRow(r)

  tableRows.mkString("\n")
}

println(buildTables())


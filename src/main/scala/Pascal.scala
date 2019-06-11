object Pascal {
  // How to use this class?
  // Load this file on the scala prompt using :load command.
  // Use it as Pascal.getVal(6).

  def getVal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (c < r) getVal(c - 1, r - 1) + getVal(c, r - 1)
    else if (c == r) 1
    else 0
  }

  def show(n: Int) = {
    for (r <- 0 to n) {
      for (c <- 0 to r) {
        print(s"${getVal(c, r)} ")
      }
      println()
    }
  }
}

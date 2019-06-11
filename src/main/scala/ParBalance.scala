object ParBalance {
  def check(S: String) = {
    var sum = 0
    var balance = true

    S.toList.foreach(c => {
      if (c == '(') sum = sum + 1
      else if (c == ')') sum = sum - 1

      if (sum < 0)
        balance = false
    })

    balance && (sum == 0)
  }
}

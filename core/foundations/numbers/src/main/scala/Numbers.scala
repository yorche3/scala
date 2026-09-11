object Numbers {
  def sum_of_first_n_rec(n: Int): Int =
    if (n <= 0) 0 else n + sum_of_first_n_rec(n - 1)

  def factorial_rec(n: Int): Int =
    if (n <= 1) 1 else n * factorial_rec(n - 1)

  def fibonacci_rec(n: Int): Int =
    if (n <= 1) n else fibonacci_rec(n - 1) + fibonacci_rec(n - 2)

  def greatest_common_divisor_rec(a: Int, b: Int): Int =
    if (b == 0) a else greatest_common_divisor_rec(b, a % b)

  def least_common_multiple_rec(a: Int, b: Int): Int =
    if (a == 0 || b == 0) 0 else (a / greatest_common_divisor_rec(a, b)) * b

  def sum_of_first_n_acc(n: Int): Int = {
    @annotation.tailrec
    def helper(current: Int, acc: Int): Int =
      if (current <= 0) acc
      else helper(current - 1, current + acc)

    helper(n, 0)
  }

  def factorial_acc(n: Int): Int = {
    @annotation.tailrec
    def helper(current: Int, acc: Int): Int =
      if (current <= 1) acc
      else helper(current - 1, current * acc)

    helper(n, 1)
  }

  def fibonacci_acc(n: Int): Int = {
    @annotation.tailrec
    def helper(position: Int, acc2: Int, acc1: Int): Int =
      if (position <= 0) acc2
      else if (position <= 2) acc1 + acc2
      else helper(position - 1, acc1, acc1 + acc2)

    helper(n, 0, 1)
  }

  def greatest_common_divisor_acc(a: Int, b: Int): Int = {
    @annotation.tailrec
    def helper(x: Int, y: Int): Int =
      if (y == 0) x else helper(y, x % y)

    helper(a, b)
  }

  def least_common_multiple_acc(a: Int, b: Int): Int =
    if (a == 0 || b == 0) 0 else (a / greatest_common_divisor_acc(a, b)) * b

  def sum_of_first_n_ite(n: Int): Int = {
    var result = 0
    var current = 1
    while (current <= n) {
      result += current
      current += 1
    }
    result
  }

  def factorial_ite(n: Int): Int = {
    var result = 1
    var current = 2
    while (current <= n) {
      result *= current
      current += 1
    }
    result
  }

  def fibonacci_ite(n: Int): Int = {
    if (n <= 1) {
      n
    } else {
      var acc2 = 0
      var acc1 = 1
      var current = 2

      while (current <= n) {
        val next = acc1 + acc2
        acc2 = acc1
        acc1 = next
        current += 1
      }

      acc1
    }
  }

  def greatest_common_divisor_ite(a: Int, b: Int): Int = {
    var x = a
    var y = b

    while (y != 0) {
      val temp = y
      y = x % y
      x = temp
    }

    x
  }

  def least_common_multiple_ite(a: Int, b: Int): Int =
    if (a == 0 || b == 0) 0 else (a / greatest_common_divisor_ite(a, b)) * b
}

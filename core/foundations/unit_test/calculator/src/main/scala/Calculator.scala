object Calculator {
  def addition(a: Int, b: Int): Int = a + b

  def subtraction(a: Int, b: Int): Int = a - b

  def multiplication(a: Int, b: Int): Int = {
    var result = 0
    var count = 0
    while (count < b) {
      result = addition(result, a)
      count += 1
    }
    result
  }

  def division(a: Int, b: Int): Int = {
    var dividend = a
    var quotient = 0
    while (dividend >= b) {
      dividend = subtraction(dividend, b)
      quotient += 1
    }
    quotient
  }

  def modulus(a: Int, b: Int): Int = {
    val quotient = division(a, b)
    val product = multiplication(quotient, b)
    subtraction(a, product)
  }
}

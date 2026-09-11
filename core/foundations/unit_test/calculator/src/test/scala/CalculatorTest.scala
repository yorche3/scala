import org.scalatest.funsuite.AnyFunSuite

class CalculatorTest extends AnyFunSuite {
  test("addition") {
    assert(Calculator.addition(2, 3) == 5)
  }

  test("subtraction") {
    assert(Calculator.subtraction(5, 2) == 3)
  }

  test("multiplication") {
    assert(Calculator.multiplication(3, 4) == 12)
  }

  test("division") {
    assert(Calculator.division(10, 3) == 3)
  }

  test("modulus") {
    assert(Calculator.modulus(10, 3) == 1)
  }
}

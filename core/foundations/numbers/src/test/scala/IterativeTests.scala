import org.scalatest.funsuite.AnyFunSuite

class IterativeTests extends AnyFunSuite {
  test("sum_of_first_n_ite") {
    assert(Numbers.sum_of_first_n_ite(0) == 0)
    assert(Numbers.sum_of_first_n_ite(3) == 6)
  }

  test("factorial_ite") {
    assert(Numbers.factorial_ite(0) == 1)
    assert(Numbers.factorial_ite(4) == 24)
  }

  test("fibonacci_ite") {
    assert(Numbers.fibonacci_ite(0) == 0)
    assert(Numbers.fibonacci_ite(1) == 1)
    assert(Numbers.fibonacci_ite(6) == 8)
  }

  test("greatest_common_divisor_ite") {
    assert(Numbers.greatest_common_divisor_ite(12, 8) == 4)
    assert(Numbers.greatest_common_divisor_ite(7, 5) == 1)
  }

  test("least_common_multiple_ite") {
    assert(Numbers.least_common_multiple_ite(4, 6) == 12)
    assert(Numbers.least_common_multiple_ite(6, 8) == 24)
  }
}

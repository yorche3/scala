import org.scalatest.funsuite.AnyFunSuite

class RecursiveTests extends AnyFunSuite {
  test("sum_of_first_n_rec") {
    assert(Numbers.sum_of_first_n_rec(0) == 0)
    assert(Numbers.sum_of_first_n_rec(3) == 6)
  }

  test("factorial_rec") {
    assert(Numbers.factorial_rec(0) == 1)
    assert(Numbers.factorial_rec(4) == 24)
  }

  test("fibonacci_rec") {
    assert(Numbers.fibonacci_rec(0) == 0)
    assert(Numbers.fibonacci_rec(1) == 1)
    assert(Numbers.fibonacci_rec(6) == 8)
  }

  test("greatest_common_divisor_rec") {
    assert(Numbers.greatest_common_divisor_rec(12, 8) == 4)
    assert(Numbers.greatest_common_divisor_rec(7, 5) == 1)
  }

  test("least_common_multiple_rec") {
    assert(Numbers.least_common_multiple_rec(4, 6) == 12)
    assert(Numbers.least_common_multiple_rec(6, 8) == 24)
  }
}

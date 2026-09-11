import org.scalatest.funsuite.AnyFunSuite

class RecursiveWithAccumulatorTests extends AnyFunSuite {
  test("sum_of_first_n_acc") {
    assert(Numbers.sum_of_first_n_acc(0) == 0)
    assert(Numbers.sum_of_first_n_acc(3) == 6)
  }

  test("factorial_acc") {
    assert(Numbers.factorial_acc(0) == 1)
    assert(Numbers.factorial_acc(4) == 24)
  }

  test("fibonacci_acc") {
    assert(Numbers.fibonacci_acc(0) == 0)
    assert(Numbers.fibonacci_acc(1) == 1)
    assert(Numbers.fibonacci_acc(6) == 8)
  }

  test("greatest_common_divisor_acc") {
    assert(Numbers.greatest_common_divisor_acc(12, 8) == 4)
    assert(Numbers.greatest_common_divisor_acc(7, 5) == 1)
  }

  test("least_common_multiple_acc") {
    assert(Numbers.least_common_multiple_acc(4, 6) == 12)
    assert(Numbers.least_common_multiple_acc(6, 8) == 24)
  }
}

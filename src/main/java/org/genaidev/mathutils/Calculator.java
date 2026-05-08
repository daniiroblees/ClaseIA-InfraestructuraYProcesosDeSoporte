package org.genaidev.mathutils;

/**
 * The {@code Calculator} class provides basic arithmetic operations
 * including addition, subtraction, multiplication, and division.
 */
public class Calculator {

  /**
   * Adds two integers.
   *
   * @param a the first integer
   * @param b the second integer
   * @return the sum of {@code a} and {@code b}
   */
  public int add(int a, int b) {
    return a + b;
  }

  /**
   * Subtracts one integer from another.
   *
   * @param a the first integer
   * @param b the second integer
   * @return the difference of {@code a} and {@code b}
   */
  public int subtract(int a, int b) {
    return a - b;
  }

  /**
   * Multiplies two integers.
   *
   * @param a the first integer
   * @param b the second integer
   * @return the product of {@code a} and {@code b}
   */
  public int multiply(int a, int b) {
    return a * b;
  }

  /**
   * Divides one integer by another.
   * <p>
   * Note: This method does not handle division by zero and will throw
   * an {@link ArithmeticException} if {@code b} is zero.
   * </p>
   *
   * @param a the numerator
   * @param b the denominator
   * @return the quotient of {@code a} divided by {@code b}
   * @throws ArithmeticException if {@code b} is zero
   */
  public int divide(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero is not allowed.");
    }
    return a / b;
  }
}

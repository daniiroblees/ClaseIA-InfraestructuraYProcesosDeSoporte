package org.genaidev.mathutils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {
  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  // ========== ADDITION TESTS ==========

  @Test
  @DisplayName("Add positive numbers")
  void testAddPositiveNumbers() {
    assertEquals(8, calculator.add(5, 3), "5 + 3 should equal 8");
    assertEquals(100, calculator.add(50, 50), "50 + 50 should equal 100");
  }

  @Test
  @DisplayName("Add negative numbers")
  void testAddNegativeNumbers() {
    assertEquals(-8, calculator.add(-5, -3), "-5 + -3 should equal -8");
    assertEquals(-100, calculator.add(-50, -50), "-50 + -50 should equal -100");
  }

  @Test
  @DisplayName("Add mixed positive and negative numbers")
  void testAddMixedNumbers() {
    assertEquals(5, calculator.add(10, -5), "10 + -5 should equal 5");
    assertEquals(-5, calculator.add(-10, 5), "-10 + 5 should equal -5");
  }

  @Test
  @DisplayName("Add zero")
  void testAddZero() {
    assertEquals(7, calculator.add(0, 7), "0 + 7 should equal 7");
    assertEquals(7, calculator.add(7, 0), "7 + 0 should equal 7");
  }

  @Test
  @DisplayName("Add both zero")
  void testAddBothZero() {
    assertEquals(0, calculator.add(0, 0), "0 + 0 should equal 0");
  }

  @Test
  @DisplayName("Add large numbers")
  void testAddLargeNumbers() {
    assertEquals(3_000_000, calculator.add(1_000_000, 2_000_000), "1M + 2M should equal 3M");
  }

  @ParameterizedTest
  @CsvSource({
      "1, 2147483646, 2147483647",
      "100, 2147483547, 2147483647",
      "2147483647, 0, 2147483647"
  })
  @DisplayName("Add boundary positive numbers")
  void testAddPositiveBoundary(int a, int b, int expected) {
    assertEquals(expected, calculator.add(a, b), 
        String.format("%d + %d should equal %d", a, b, expected));
  }

  @ParameterizedTest
  @CsvSource({
      "-1, -2147483647, -2147483648",
      "-100, -2147483548, -2147483648",
      "-2147483648, 0, -2147483648"
  })
  @DisplayName("Add boundary negative numbers")
  void testAddNegativeBoundary(int a, int b, int expected) {
    assertEquals(expected, calculator.add(a, b), 
        String.format("%d + %d should equal %d", a, b, expected));
  }

  // ========== SUBTRACTION TESTS ==========

  @Test
  @DisplayName("Subtract positive numbers")
  void testSubtractPositiveNumbers() {
    assertEquals(7, calculator.subtract(10, 3), "10 - 3 should equal 7");
    assertEquals(50, calculator.subtract(100, 50), "100 - 50 should equal 50");
  }

  @Test
  @DisplayName("Subtract negative numbers")
  void testSubtractNegativeNumbers() {
    assertEquals(-2, calculator.subtract(-5, -3), "-5 - -3 should equal -2");
    assertEquals(-50, calculator.subtract(-100, -50), "-100 - -50 should equal -50");
  }

  @Test
  @DisplayName("Subtract mixed positive and negative numbers")
  void testSubtractMixedNumbers() {
    assertEquals(15, calculator.subtract(10, -5), "10 - -5 should equal 15");
    assertEquals(-15, calculator.subtract(-10, 5), "-10 - 5 should equal -15");
  }

  @Test
  @DisplayName("Subtract from zero")
  void testSubtractFromZero() {
    assertEquals(-7, calculator.subtract(0, 7), "0 - 7 should equal -7");
    assertEquals(7, calculator.subtract(0, -7), "0 - -7 should equal 7");
  }

  @Test
  @DisplayName("Subtract zero")
  void testSubtractZero() {
    assertEquals(10, calculator.subtract(10, 0), "10 - 0 should equal 10");
    assertEquals(-10, calculator.subtract(-10, 0), "-10 - 0 should equal -10");
  }

  @Test
  @DisplayName("Subtract self")
  void testSubtractSelf() {
    assertEquals(0, calculator.subtract(100, 100), "100 - 100 should equal 0");
    assertEquals(0, calculator.subtract(-100, -100), "-100 - -100 should equal 0");
  }

  @ParameterizedTest
  @CsvSource({
      "5, 5, 0",
      "2147483647, 2147483647, 0",
      "-2147483648, -2147483648, 0"
  })
  @DisplayName("Subtract to zero")
  void testSubtractToZero(int a, int b, int expected) {
    assertEquals(expected, calculator.subtract(a, b), 
        String.format("%d - %d should equal %d", a, b, expected));
  }

  // ========== MULTIPLICATION TESTS ==========

  @Test
  @DisplayName("Multiply positive numbers")
  void testMultiplyPositiveNumbers() {
    assertEquals(12, calculator.multiply(4, 3), "4 * 3 should equal 12");
    assertEquals(100, calculator.multiply(10, 10), "10 * 10 should equal 100");
  }

  @Test
  @DisplayName("Multiply negative numbers")
  void testMultiplyNegativeNumbers() {
    assertEquals(12, calculator.multiply(-4, -3), "-4 * -3 should equal 12");
    assertEquals(100, calculator.multiply(-10, -10), "-10 * -10 should equal 100");
  }

  @Test
  @DisplayName("Multiply mixed positive and negative numbers")
  void testMultiplyMixedNumbers() {
    assertEquals(-12, calculator.multiply(4, -3), "4 * -3 should equal -12");
    assertEquals(-12, calculator.multiply(-4, 3), "-4 * 3 should equal -12");
  }

  @Test
  @DisplayName("Multiply by zero")
  void testMultiplyByZero() {
    assertEquals(0, calculator.multiply(5, 0), "5 * 0 should equal 0");
    assertEquals(0, calculator.multiply(0, 5), "0 * 5 should equal 0");
    assertEquals(0, calculator.multiply(0, 0), "0 * 0 should equal 0");
  }

  @Test
  @DisplayName("Multiply by one")
  void testMultiplyByOne() {
    assertEquals(7, calculator.multiply(7, 1), "7 * 1 should equal 7");
    assertEquals(7, calculator.multiply(1, 7), "1 * 7 should equal 7");
    assertEquals(-7, calculator.multiply(-7, 1), "-7 * 1 should equal -7");
  }

  @Test
  @DisplayName("Multiply large numbers")
  void testMultiplyLargeNumbers() {
    assertEquals(1_000_000, calculator.multiply(1000, 1000), "1000 * 1000 should equal 1M");
  }

  // ========== DIVISION TESTS ==========

  @Test
  @DisplayName("Divide positive numbers")
  void testDividePositiveNumbers() {
    assertEquals(4, calculator.divide(12, 3), "12 / 3 should equal 4");
    assertEquals(10, calculator.divide(100, 10), "100 / 10 should equal 10");
  }

  @Test
  @DisplayName("Divide negative numbers")
  void testDivideNegativeNumbers() {
    assertEquals(4, calculator.divide(-12, -3), "-12 / -3 should equal 4");
    assertEquals(10, calculator.divide(-100, -10), "-100 / -10 should equal 10");
  }

  @Test
  @DisplayName("Divide mixed positive and negative numbers")
  void testDivideMixedNumbers() {
    assertEquals(-4, calculator.divide(12, -3), "12 / -3 should equal -4");
    assertEquals(-4, calculator.divide(-12, 3), "-12 / 3 should equal -4");
  }

  @Test
  @DisplayName("Divide by one")
  void testDivideByOne() {
    assertEquals(15, calculator.divide(15, 1), "15 / 1 should equal 15");
    assertEquals(-15, calculator.divide(-15, 1), "-15 / 1 should equal -15");
  }

  @Test
  @DisplayName("Divide self")
  void testDivideSelf() {
    assertEquals(1, calculator.divide(10, 10), "10 / 10 should equal 1");
    assertEquals(1, calculator.divide(-10, -10), "-10 / -10 should equal 1");
  }

  @Test
  @DisplayName("Divide zero by positive")
  void testDivideZeroByPositive() {
    assertEquals(0, calculator.divide(0, 5), "0 / 5 should equal 0");
  }

  @Test
  @DisplayName("Divide zero by negative")
  void testDivideZeroByNegative() {
    assertEquals(0, calculator.divide(0, -5), "0 / -5 should equal 0");
  }

  @Test
  @DisplayName("Divide large numbers")
  void testDivideLargeNumbers() {
    assertEquals(10_000, calculator.divide(1_000_000, 100), "1M / 100 should equal 10K");
  }

  @ParameterizedTest
  @CsvSource({
      "7, 3, 2",
      "-7, 3, -2",
      "7, -3, -2",
      "-7, -3, 2",
      "1, 100, 0",
      "-1, 100, 0"
  })
  @DisplayName("Divide with remainder (integer division)")
  void testDivideWithRemainder(int a, int b, int expected) {
    assertEquals(expected, calculator.divide(a, b), 
        String.format("%d / %d should equal %d", a, b, expected));
  }

  @Test
  @DisplayName("Divide by zero throws ArithmeticException")
  void testDivideByZero() {
    ArithmeticException exception = assertThrows(
        ArithmeticException.class,
        () -> calculator.divide(10, 0),
        "Dividing by zero should throw ArithmeticException"
    );
    assertEquals("Division by zero is not allowed.", exception.getMessage(), 
        "Exception message should be specific");
  }

  @Test
  @DisplayName("Divide negative by zero throws ArithmeticException")
  void testDivideNegativeByZero() {
    assertThrows(
        ArithmeticException.class,
        () -> calculator.divide(-10, 0),
        "Dividing negative by zero should throw ArithmeticException"
    );
  }

  @Test
  @DisplayName("Divide zero by zero throws ArithmeticException")
  void testDivideZeroByZero() {
    assertThrows(
        ArithmeticException.class,
        () -> calculator.divide(0, 0),
        "Dividing zero by zero should throw ArithmeticException"
    );
  }
}

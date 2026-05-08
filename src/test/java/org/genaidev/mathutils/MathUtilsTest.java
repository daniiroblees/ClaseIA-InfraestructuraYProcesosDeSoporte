package org.genaidev.mathutils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

  // ========== IS EVEN TESTS ==========

  @Test
  @DisplayName("isEven with positive even numbers")
  void testIsEvenPositiveEven() {
    assertTrue(MathUtils.isEven(2), "2 should be even");
    assertTrue(MathUtils.isEven(4), "4 should be even");
    assertTrue(MathUtils.isEven(10), "10 should be even");
    assertTrue(MathUtils.isEven(100), "100 should be even");
  }

  @Test
  @DisplayName("isEven with positive odd numbers")
  void testIsEvenPositiveOdd() {
    assertFalse(MathUtils.isEven(1), "1 should be odd");
    assertFalse(MathUtils.isEven(3), "3 should be odd");
    assertFalse(MathUtils.isEven(5), "5 should be odd");
    assertFalse(MathUtils.isEven(99), "99 should be odd");
  }

  @Test
  @DisplayName("isEven with negative even numbers")
  void testIsEvenNegativeEven() {
    assertTrue(MathUtils.isEven(-2), "-2 should be even");
    assertTrue(MathUtils.isEven(-4), "-4 should be even");
    assertTrue(MathUtils.isEven(-10), "-10 should be even");
    assertTrue(MathUtils.isEven(-100), "-100 should be even");
  }

  @Test
  @DisplayName("isEven with negative odd numbers")
  void testIsEvenNegativeOdd() {
    assertFalse(MathUtils.isEven(-1), "-1 should be odd");
    assertFalse(MathUtils.isEven(-3), "-3 should be odd");
    assertFalse(MathUtils.isEven(-5), "-5 should be odd");
    assertFalse(MathUtils.isEven(-99), "-99 should be odd");
  }

  @Test
  @DisplayName("isEven with zero")
  void testIsEvenZero() {
    assertTrue(MathUtils.isEven(0), "0 should be even");
  }

  @Test
  @DisplayName("isEven with maximum integer")
  void testIsEvenMaxInteger() {
    assertFalse(MathUtils.isEven(Integer.MAX_VALUE), "Integer.MAX_VALUE should be odd");
  }

  @Test
  @DisplayName("isEven with minimum integer")
  void testIsEvenMinInteger() {
    assertTrue(MathUtils.isEven(Integer.MIN_VALUE), "Integer.MIN_VALUE should be even");
  }

  @Test
  @DisplayName("isEven with large numbers")
  void testIsEvenLargeNumbers() {
    assertTrue(MathUtils.isEven(1_000_000), "1_000_000 should be even");
    assertFalse(MathUtils.isEven(1_000_001), "1_000_001 should be odd");
    assertTrue(MathUtils.isEven(-1_000_000), "-1_000_000 should be even");
    assertFalse(MathUtils.isEven(-1_000_001), "-1_000_001 should be odd");
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 4, 6, 8, 10, 100, 1000})
  @DisplayName("isEven with various even numbers")
  void testIsEvenBoundaryEven(int number) {
    assertTrue(MathUtils.isEven(number), 
        String.format("%d should be even", number));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 5, 7, 9, 99, 999})
  @DisplayName("isEven with various odd numbers")
  void testIsEvenBoundaryOdd(int number) {
    assertFalse(MathUtils.isEven(number), 
        String.format("%d should be odd", number));
  }

  @ParameterizedTest
  @CsvSource({
      "2, true",
      "3, false",
      "0, true",
      "-2, true",
      "-3, false",
      "2147483646, true",
      "2147483647, false",
      "-2147483648, true",
      "-2147483647, false"
  })
  @DisplayName("isEven comprehensive test")
  void testIsEvenComprehensive(int number, boolean expected) {
    assertEquals(expected, MathUtils.isEven(number), 
        String.format("%d should be %s", number, expected ? "even" : "odd"));
  }

  // ========== IS POSITIVE TESTS ==========

  @Test
  @DisplayName("isPositive with positive numbers")
  void testIsPositivePositive() {
    assertTrue(MathUtils.isPositive(1), "1 should be positive");
    assertTrue(MathUtils.isPositive(5), "5 should be positive");
    assertTrue(MathUtils.isPositive(100), "100 should be positive");
    assertTrue(MathUtils.isPositive(Integer.MAX_VALUE), "Integer.MAX_VALUE should be positive");
  }

  @Test
  @DisplayName("isPositive with negative numbers")
  void testIsPositiveNegative() {
    assertFalse(MathUtils.isPositive(-1), "-1 should not be positive");
    assertFalse(MathUtils.isPositive(-5), "-5 should not be positive");
    assertFalse(MathUtils.isPositive(-100), "-100 should not be positive");
    assertFalse(MathUtils.isPositive(Integer.MIN_VALUE), "Integer.MIN_VALUE should not be positive");
  }

  @Test
  @DisplayName("isPositive with zero")
  void testIsPositiveZero() {
    assertFalse(MathUtils.isPositive(0), "0 should not be positive");
  }

  @Test
  @DisplayName("isPositive with boundary values")
  void testIsPositiveBoundary() {
    assertTrue(MathUtils.isPositive(1), "1 should be positive (boundary)");
    assertFalse(MathUtils.isPositive(0), "0 should not be positive (boundary)");
    assertFalse(MathUtils.isPositive(-1), "-1 should not be positive (boundary)");
  }

  @Test
  @DisplayName("isPositive with large positive numbers")
  void testIsPositiveLargePositive() {
    assertTrue(MathUtils.isPositive(1_000_000), "1_000_000 should be positive");
    assertTrue(MathUtils.isPositive(1_000_000_000), "1_000_000_000 should be positive");
  }

  @Test
  @DisplayName("isPositive with large negative numbers")
  void testIsPositiveLargeNegative() {
    assertFalse(MathUtils.isPositive(-1_000_000), "-1_000_000 should not be positive");
    assertFalse(MathUtils.isPositive(-1_000_000_000), "-1_000_000_000 should not be positive");
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 10, 100, 1000, Integer.MAX_VALUE})
  @DisplayName("isPositive with various positive numbers")
  void testIsPositiveVariousPositive(int number) {
    assertTrue(MathUtils.isPositive(number), 
        String.format("%d should be positive", number));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -1, -2, -10, -100, -1000, Integer.MIN_VALUE})
  @DisplayName("isPositive with various non-positive numbers")
  void testIsPositiveVariousNonPositive(int number) {
    assertFalse(MathUtils.isPositive(number), 
        String.format("%d should not be positive", number));
  }

  @ParameterizedTest
  @CsvSource({
      "1, true",
      "0, false",
      "-1, false",
      "100, true",
      "-100, false",
      "2147483647, true",
      "-2147483648, false"
  })
  @DisplayName("isPositive comprehensive test")
  void testIsPositiveComprehensive(int number, boolean expected) {
    assertEquals(expected, MathUtils.isPositive(number), 
        String.format("%d should %sbe positive", number, expected ? "" : "not "));
  }

  // ========== EDGE CASE AND SPECIAL TESTS ==========

  @Test
  @DisplayName("isEven and isPositive relationship")
  void testIsEvenIsPositiveRelationship() {
    // Test that both methods work correctly together
    assertTrue(MathUtils.isEven(2) && MathUtils.isPositive(2), "2 should be even and positive");
    assertTrue(MathUtils.isEven(-2) && !MathUtils.isPositive(-2), "-2 should be even and not positive");
    assertFalse(MathUtils.isEven(1) && MathUtils.isPositive(1), "1 should be odd but positive");
    assertFalse(MathUtils.isEven(-1) && !MathUtils.isPositive(-1), "-1 should be odd and not positive");
  }

  @Test
  @DisplayName("Test with extreme values")
  void testExtremeValues() {
    // Test with Integer.MAX_VALUE (odd and positive)
    assertFalse(MathUtils.isEven(Integer.MAX_VALUE));
    assertTrue(MathUtils.isPositive(Integer.MAX_VALUE));
    
    // Test with Integer.MIN_VALUE (even and negative)
    assertTrue(MathUtils.isEven(Integer.MIN_VALUE));
    assertFalse(MathUtils.isPositive(Integer.MIN_VALUE));
  }

  @Test
  @DisplayName("Test with consecutive numbers")
  void testConsecutiveNumbers() {
    // Test a range of consecutive numbers to ensure consistency
    for (int i = -5; i <= 5; i++) {
      boolean expectedEven = (i % 2 == 0);
      boolean expectedPositive = (i > 0);
      
      assertEquals(expectedEven, MathUtils.isEven(i), 
          String.format("isEven(%d) should be %b", i, expectedEven));
      assertEquals(expectedPositive, MathUtils.isPositive(i), 
          String.format("isPositive(%d) should be %b", i, expectedPositive));
    }
  }

  @Test
  @DisplayName("Test method performance hint")
  void testMethodPerformanceHint() {
    // This is just a basic performance hint test
    // In a real scenario, you'd use JMH for proper benchmarking
    long startTime = System.nanoTime();
    
    // Perform a reasonable number of operations
    for (int i = 0; i < 10000; i++) {
      MathUtils.isEven(i);
      MathUtils.isPositive(i);
    }
    
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    
    // Just ensure it completes in a reasonable time (less than 1 second)
    assertTrue(duration < 1_000_000_000L, 
        "Methods should complete within reasonable time");
  }

  // ========== MEDIAN TESTS ==========

  @Test
  @DisplayName("Median with odd number of elements")
  void testMedianOddNumberOfElements() {
    List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2);
    double result = MathUtils.median(numbers);
    assertEquals(3.0, result, 0.001, "Median of [3,1,4,1,5,9,2] should be 3.0");
  }

  @Test
  @DisplayName("Median with even number of elements")
  void testMedianEvenNumberOfElements() {
    List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
    double result = MathUtils.median(numbers);
    assertEquals(3.5, result, 0.001, "Median of [3,1,4,1,5,9] should be 3.5");
  }

  @Test
  @DisplayName("Median with single element")
  void testMedianSingleElement() {
    List<Integer> numbers = Arrays.asList(42);
    double result = MathUtils.median(numbers);
    assertEquals(42.0, result, 0.001, "Median of [42] should be 42.0");
  }

  @Test
  @DisplayName("Median with two elements")
  void testMedianTwoElements() {
    List<Integer> numbers = Arrays.asList(1, 9);
    double result = MathUtils.median(numbers);
    assertEquals(5.0, result, 0.001, "Median of [1,9] should be 5.0");
  }

  @Test
  @DisplayName("Median with already sorted list")
  void testMedianSortedList() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    double result = MathUtils.median(numbers);
    assertEquals(3.0, result, 0.001, "Median of [1,2,3,4,5] should be 3.0");
  }

  @Test
  @DisplayName("Median with reverse sorted list")
  void testMedianReverseSortedList() {
    List<Integer> numbers = Arrays.asList(5, 4, 3, 2, 1);
    double result = MathUtils.median(numbers);
    assertEquals(3.0, result, 0.001, "Median of [5,4,3,2,1] should be 3.0");
  }

  @Test
  @DisplayName("Median with negative numbers")
  void testMedianWithNegativeNumbers() {
    List<Integer> numbers = Arrays.asList(-3, -1, -4, -1, -5);
    double result = MathUtils.median(numbers);
    assertEquals(-3.0, result, 0.001, "Median of [-3,-1,-4,-1,-5] should be -3.0");
  }

  @Test
  @DisplayName("Median with mixed positive and negative numbers")
  void testMedianMixedNumbers() {
    List<Integer> numbers = Arrays.asList(-2, 0, 2, 4, -4);
    double result = MathUtils.median(numbers);
    assertEquals(0.0, result, 0.001, "Median of [-2,0,2,4,-4] should be 0.0");
  }

  @Test
  @DisplayName("Median with duplicate elements")
  void testMedianWithDuplicates() {
    List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
    double result = MathUtils.median(numbers);
    assertEquals(3.0, result, 0.001, "Median of [1,2,2,3,3,3,4] should be 3.0");
  }

  @Test
  @DisplayName("Median with all same elements")
  void testMedianAllSameElements() {
    List<Integer> numbers = Arrays.asList(5, 5, 5, 5, 5);
    double result = MathUtils.median(numbers);
    assertEquals(5.0, result, 0.001, "Median of [5,5,5,5,5] should be 5.0");
  }

  @Test
  @DisplayName("Median with large numbers")
  void testMedianLargeNumbers() {
    List<Integer> numbers = Arrays.asList(1000000, 2000000, 3000000);
    double result = MathUtils.median(numbers);
    assertEquals(2000000.0, result, 0.001, "Median of [1000000,2000000,3000000] should be 2000000.0");
  }

  @Test
  @DisplayName("Median throws exception for null list")
  void testMedianNullList() {
    assertThrows(IllegalArgumentException.class,
        () -> MathUtils.median(null),
        "Median should throw IllegalArgumentException for null list");
  }

  @Test
  @DisplayName("Median throws exception for empty list")
  void testMedianEmptyList() {
    List<Integer> emptyList = Collections.emptyList();
    assertThrows(IllegalArgumentException.class,
        () -> MathUtils.median(emptyList),
        "Median should throw IllegalArgumentException for empty list");
  }

  @Test
  @DisplayName("Median exception message for null list")
  void testMedianNullListExceptionMessage() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> MathUtils.median(null)
    );
    assertEquals("List cannot be null or empty", exception.getMessage(),
        "Exception message should be specific");
  }

  @Test
  @DisplayName("Median exception message for empty list")
  void testMedianEmptyListExceptionMessage() {
    List<Integer> emptyList = Collections.emptyList();
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> MathUtils.median(emptyList)
    );
    assertEquals("List cannot be null or empty", exception.getMessage(),
        "Exception message should be specific");
  }

  @ParameterizedTest
  @CsvSource({
      "1, 1.0",
      "2, 1.5",
      "3, 2.0",
      "4, 2.5",
      "5, 3.0",
      "6, 3.5",
      "7, 4.0",
      "8, 4.5",
      "9, 5.0",
      "10, 5.5"
  })
  @DisplayName("Median with sequential numbers")
  void testMedianSequentialNumbers(int size, double expected) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= size; i++) {
      numbers.add(i);
    }
    double result = MathUtils.median(numbers);
    assertEquals(expected, result, 0.001, 
        String.format("Median of first %d numbers should be %.1f", size, expected));
  }

  @ParameterizedTest
  @CsvSource({
      "1, -1.0",
      "2, -1.5",
      "3, -2.0",
      "4, -2.5",
      "5, -3.0",
      "6, -3.5",
      "7, -4.0",
      "8, -4.5",
      "9, -5.0",
      "10, -5.5"
  })
  @DisplayName("Median with negative sequential numbers")
  void testMedianNegativeSequentialNumbers(int size, double expected) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = -1; i >= -size; i--) {
      numbers.add(i);
    }
    double result = MathUtils.median(numbers);
    assertEquals(expected, result, 0.001, 
        String.format("Median of first %d negative numbers should be %.1f", size, expected));
  }

  @Test
  @DisplayName("Median does not modify original list")
  void testMedianDoesNotModifyOriginalList() {
    List<Integer> originalList = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5));
    List<Integer> expectedList = new ArrayList<>(originalList);
    
    MathUtils.median(originalList);
    
    assertEquals(expectedList, originalList, "Original list should not be modified");
  }

  @Test
  @DisplayName("Median with integer boundaries")
  void testMedianIntegerBoundaries() {
    List<Integer> numbers = Arrays.asList(Integer.MIN_VALUE, 0, Integer.MAX_VALUE);
    double result = MathUtils.median(numbers);
    assertEquals(0.0, result, 0.001, "Median of [MIN,0,MAX] should be 0.0");
  }
}

# MathUtils Test Plan

## Overview
This document outlines a comprehensive testing strategy for the MathUtils project, covering both the `Calculator` and `MathUtils` classes. The plan includes unit tests, edge cases, boundary testing, and error handling validation.

## Test Categories

### 1. Unit Tests
- Basic functionality validation
- Method behavior verification
- Return value accuracy

### 2. Edge Case Tests
- Boundary conditions
- Extreme values
- Special numeric cases

### 3. Error Handling Tests
- Exception validation
- Invalid input scenarios
- Error message verification

### 4. Performance Tests
- Execution time measurement
- Memory usage validation
- Stress testing (if applicable)

---

## Calculator Class Test Plan

### 1. Addition Tests (`add(int a, int b)`)

#### Basic Functionality Tests
- **testAddPositiveNumbers**: 5 + 3 = 8
- **testAddNegativeNumbers**: (-5) + (-3) = -8
- **testAddMixedNumbers**: 10 + (-5) = 5
- **testAddZero**: 0 + 7 = 7
- **testAddBothZero**: 0 + 0 = 0

#### Edge Case Tests
- **testAddMaxInteger**: Integer.MAX_VALUE + 1 (expect overflow behavior)
- **testAddMinInteger**: Integer.MIN_VALUE + (-1) (expect overflow behavior)
- **testAddLargeNumbers**: 1_000_000 + 2_000_000 = 3_000_000

#### Boundary Tests
- **testAddPositiveBoundary**: 1 + Integer.MAX_VALUE - 1 = Integer.MAX_VALUE
- **testAddNegativeBoundary**: (-1) + Integer.MIN_VALUE + 1 = Integer.MIN_VALUE

### 2. Subtraction Tests (`subtract(int a, int b)`)

#### Basic Functionality Tests
- **testSubtractPositiveNumbers**: 10 - 3 = 7
- **testSubtractNegativeNumbers**: (-5) - (-3) = -2
- **testSubtractMixedNumbers**: 10 - (-5) = 15
- **testSubtractFromZero**: 0 - 7 = -7
- **testSubtractZero**: 10 - 0 = 10

#### Edge Case Tests
- **testSubtractMaxInteger**: Integer.MAX_VALUE - (-1) (expect overflow)
- **testSubtractMinInteger**: Integer.MIN_VALUE - 1 (expect overflow)
- **testSubtractSelf**: 100 - 100 = 0

#### Boundary Tests
- **testSubtractToZero**: 5 - 5 = 0
- **testSubtractFromMaxToMin**: Integer.MAX_VALUE - Integer.MAX_VALUE = 0

### 3. Multiplication Tests (`multiply(int a, int b)`)

#### Basic Functionality Tests
- **testMultiplyPositiveNumbers**: 4 * 3 = 12
- **testMultiplyNegativeNumbers**: (-4) * (-3) = 12
- **testMultiplyMixedNumbers**: 4 * (-3) = -12
- **testMultiplyByZero**: 5 * 0 = 0
- **testMultiplyByOne**: 7 * 1 = 7

#### Edge Case Tests
- **testMultiplyMaxInteger**: Integer.MAX_VALUE * 2 (expect overflow)
- **testMultiplyMinInteger**: Integer.MIN_VALUE * 2 (expect overflow)
- **testMultiplyLargeNumbers**: 1000 * 1000 = 1_000_000

#### Special Cases
- **testMultiplyNegativeByPositive**: (-5) * 3 = -15
- **testMultiplyTwoNegatives**: (-5) * (-3) = 15

### 4. Division Tests (`divide(int a, int b)`)

#### Basic Functionality Tests
- **testDividePositiveNumbers**: 12 / 3 = 4
- **testDivideNegativeNumbers**: (-12) / (-3) = 4
- **testDivideMixedNumbers**: 12 / (-3) = -4
- **testDivideByOne**: 15 / 1 = 15
- **testDivideSelf**: 10 / 10 = 1

#### Edge Case Tests
- **testDivideZeroByPositive**: 0 / 5 = 0
- **testDivideZeroByNegative**: 0 / (-5) = 0
- **testDivideLargeNumbers**: 1_000_000 / 100 = 10_000

#### Integer Division Tests
- **testDivideWithRemainder**: 7 / 3 = 2 (integer division)
- **testDivideNegativeRemainder**: (-7) / 3 = -2 (integer division)
- **testDivideSmallByLarge**: 1 / 100 = 0

#### Error Handling Tests
- **testDivideByZero**: 10 / 0 throws ArithmeticException
- **testDivideNegativeByZero**: (-10) / 0 throws ArithmeticException
- **testDivideZeroByZero**: 0 / 0 throws ArithmeticException
- **testDivideByZeroExceptionMessage**: Verify exception message content

---

## MathUtils Class Test Plan

### 1. isEven Tests (`isEven(int number)`)

#### Basic Functionality Tests
- **testIsEvenPositiveEven**: 4 returns true
- **testIsEvenPositiveOdd**: 5 returns false
- **testIsEvenNegativeEven**: (-4) returns true
- **testIsEvenNegativeOdd**: (-5) returns false
- **testIsEvenZero**: 0 returns true

#### Edge Case Tests
- **testIsEvenMaxInteger**: Integer.MAX_VALUE returns false
- **testIsEvenMinInteger**: Integer.MIN_VALUE returns true
- **testIsEvenLargeNumbers**: 1_000_000 returns true

#### Boundary Tests
- **testIsEvenBoundaryEven**: 2 returns true
- **testIsEvenBoundaryOdd**: 1 returns false

### 2. isPositive Tests (`isPositive(int number)`)

#### Basic Functionality Tests
- **testIsPositivePositive**: 5 returns true
- **testIsPositiveNegative**: (-5) returns false
- **testIsPositiveZero**: 0 returns false

#### Edge Case Tests
- **testIsPositiveMaxInteger**: Integer.MAX_VALUE returns true
- **testIsPositiveMinInteger**: Integer.MIN_VALUE returns false
- **testIsPositiveOne**: 1 returns true
- **testIsPositiveNegativeOne**: (-1) returns false

#### Boundary Tests
- **testIsPositiveBoundary**: 0 returns false (boundary case)
- **testIsPositiveSmallPositive**: 1 returns true
- **testIsPositiveSmallNegative**: (-1) returns false

---

## Test Structure Recommendations

### Test Class Organization
```
src/test/java/org/genaidev/mathutils/
├── CalculatorTest.java          # Existing tests + new tests
├── MathUtilsTest.java          # New test class needed
└── CalculatorPerformanceTest.java  # Optional performance tests
```

### Test Method Naming Convention
- **Positive tests**: `test[MethodName][Scenario]`
- **Negative tests**: `test[MethodName][ErrorCondition]`
- **Edge cases**: `test[MethodName][EdgeCase]`
- **Boundary tests**: `test[MethodName][Boundary]`

### Test Data Organization
- Use `@ParameterizedTest` for multiple similar test cases
- Consider `@MethodSource` for complex test data
- Use `@ValueSource` for simple parameter arrays

---

## Test Coverage Goals

### Coverage Metrics
- **Line Coverage**: Target 100%
- **Branch Coverage**: Target 100%
- **Method Coverage**: Target 100%

### Coverage Categories
- [ ] All public methods tested
- [ ] All exception paths tested
- [ ] All boundary conditions tested
- [ ] All edge cases tested

---

## Test Execution Strategy

### Maven Commands
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=CalculatorTest

# Run specific test method
mvn test -Dtest=CalculatorTest#testAddPositiveNumbers

# Generate test coverage report
mvn jacoco:report
```

### Test Categories Execution
1. **Unit Tests**: Run on every build
2. **Integration Tests**: Run on pre-release
3. **Performance Tests**: Run on demand
4. **Regression Tests**: Run before releases

---

## Test Data Examples

### Parameterized Test Data Examples

#### Addition Test Data
```java
@ParameterizedTest
@CsvSource({
    "5, 3, 8",
    "-5, -3, -8",
    "10, -5, 5",
    "0, 7, 7",
    "0, 0, 0"
})
void testAdd(int a, int b, int expected) { ... }
```

#### isEven Test Data
```java
@ParameterizedTest
@ValueSource(ints = {0, 2, 4, -2, -4, Integer.MAX_VALUE, Integer.MIN_VALUE})
void testIsEven(int number) { ... }
```

---

## Test Environment Setup

### Required Dependencies
- JUnit 5.10.3 (already configured)
- Optional: JaCoCo for coverage reports
- Optional: JUnit Parameterized Tests

### Test Configuration
- Maven Surefire Plugin (already configured)
- Test source directory: `src/test/java`
- Test naming convention: `*Test.java`

---

## Future Test Enhancements

### Potential Additional Tests
1. **Performance Tests**: Benchmark critical operations
2. **Integration Tests**: Test with other components
3. **Regression Tests**: Ensure fixes don't break existing functionality
4. **Load Tests**: Test behavior under high load (if applicable)

### Test Automation
- Continuous Integration integration
- Automated test execution on commits
- Test result reporting and notifications

---

## Test Maintenance

### Regular Reviews
- Review test coverage metrics
- Update tests for new features
- Remove obsolete tests
- Optimize slow-running tests

### Documentation Updates
- Keep test plan current with code changes
- Document any special test requirements
- Maintain test data documentation

---

*This test plan provides comprehensive coverage for the MathUtils project while maintaining test organization and maintainability.*

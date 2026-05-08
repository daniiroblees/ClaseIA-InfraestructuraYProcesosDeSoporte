package org.genaidev.mathutils;

/**
 * Auxiliary math utilities.
 */
public class MathUtils {

    /**
     * Checks if a number is even.
     *
     * @param number the number to check
     * @return true if the number is even, false otherwise
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Checks if a number is positive.
     *
     * @param number the number to check
     * @return true if the number is greater than zero, false otherwise
     */
    public static boolean isPositive(int number) {
        return number > 0;
    }
}
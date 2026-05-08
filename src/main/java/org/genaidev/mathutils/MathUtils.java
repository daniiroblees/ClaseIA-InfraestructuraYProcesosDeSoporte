package org.genaidev.mathutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    /**
     * Compute the median of a list of integers.
     * The median is the middle value when the list is sorted.
     * For even-sized lists, it returns the average of the two middle values.
     *
     * @param numbers the list of integers to calculate the median from
     * @return the median value as a double
     * @throws IllegalArgumentException if the list is null or empty
     */
    public static double median(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        
        // Create a copy to avoid modifying the original list
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        
        int size = sortedNumbers.size();
        int middleIndex = size / 2;
        
        if (size % 2 == 1) {
            // Odd number of elements - return the middle element
            return sortedNumbers.get(middleIndex);
        } else {
            // Even number of elements - return average of two middle elements
            int middle1 = sortedNumbers.get(middleIndex - 1);
            int middle2 = sortedNumbers.get(middleIndex);
            return (middle1 + middle2) / 2.0;
        }
    }
}
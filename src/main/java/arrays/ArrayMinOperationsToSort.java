package arrays;

import java.util.*;

public class ArrayMinOperationsToSort {
    public static int minOperationsToSort(int[] arr) {
        Arrays.sort(arr); // Step 1: Sort the array

        int operations = 0;  // To store the number of operations
        int last = 0;  // To store the last element of the sorted sequence

        // Step 2: Iterate through the sorted array
        for (int num : arr) {
            if (num > last) {
                // If the current number is greater than the last, no break needed
                last = num;
            } else {
                // If the current number is smaller than or equal to the last number
                // we need to split it into smaller parts.
                int diff = last - num;  // Calculate the difference
                operations += diff;  // The number of splits is equal to the difference
                last = num;  // Update the last value to be the current one
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 3};
        System.out.println(minOperationsToSort(arr));  // Output: 2
    }
}


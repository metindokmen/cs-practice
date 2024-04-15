// Counting Sort algorithm is a linear-time sorting algorithm suitable for a specific range of integer inputs.
// It works by counting the occurrences of each element and using this information to place the elements in order.
// It requires prior knowledge of the range of elements in the input array.
// The algorithm involves three main steps:

// 1. Counting: Count the occurrences of each element in the input array.
// 2. Computing Cumulative Counts: Calculate cumulative counts to determine the position of each element in the sorted array.
// 3. Sorting: Place each element into its correct position in the output array based on the cumulative counts.

// Consider sorting exam scores (ranging from 0 to 100) obtained by students in a class.
// Counting Sort can efficiently sort these scores since they fall within a specific range.

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        int max = Arrays.stream(arr).max().orElse(0); // Find the maximum value in the array

        // Create a count array to store the count of each element.
        int[] count = new int[max + 1];

        // Store the count of each element in the count array.
        for (int value : arr) {
            count[value]++;
        }

        // Modify the count array to store the actual position of each element in the output array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Create a temporary array to store the sorted elements
        int[] output = new int[n];

        // Build the output array using the count array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the sorted elements from the output array to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

}
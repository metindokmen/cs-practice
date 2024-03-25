// Binary Search is an efficient algorithm for finding a target value within a sorted array.
// It works by repeatedly dividing in half the portion of the list that could contain the target value, and comparing the target value to the middle element of the subarray.
// The algorithm eliminates the half in which the target value cannot lie in each iteration.

// Imagine you have a phonebook with names sorted alphabetically.
// You want to find a specific person's phone number.
// Instead of starting from the beginning and looking at each name one by one, you decide to open the phonebook roughly in the middle.
// If the name you're looking for comes after the middle name alphabetically, you repeat the process with the second half of the phonebook.
// Otherwise, you repeat the process with the first half.
// You keep repeating this process until you find the name you're looking for or determine it's not in the phonebook.

public class BinarySearch {
    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target)
                return mid;

            // If target is greater, ignore left half
            if (arr[mid] < target)
                left = mid + 1;
            // If target is smaller, ignore right half
            else
                right = mid - 1;
        }

        // If we reach here, then element was not present
        return -1;
    }

    public static void main(String[] args) {
        int[] arr= { 2, 3, 4, 10, 40 };
        int target = 10;
        int result = binarySearch(arr, target);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}

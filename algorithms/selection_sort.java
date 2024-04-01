// Selection Sort is a simple sorting algorithm that works
// by repeatedly selecting the minimum element from the unsorted portion of the array and moving it to the beginning.

// Suppose you have a deck of cards that are not in any particular order,
// and you want to arrange them in ascending order based on their values.
// You can use the selection sort algorithm to achieve this.

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        selectionSort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
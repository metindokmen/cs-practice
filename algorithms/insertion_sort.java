// Insertion Sort is a simple sorting algorithm that builds the final sorted array one item at a time.
// It iterates through an input array, removing one element at a time and then inserting it into the correct position in the sorted array.

// Imagine you have a deck of cards that are initially unsorted.
// To sort the deck using insertion sort, you would start with an empty hand and pick up one card at a time from the unsorted deck.
// As you pick up each card, you compare it to the cards already in your hand and insert it into the correct position.
// By the time you've picked up all the cards from the unsorted deck, your hand will contain all the cards sorted from lowest to highest.

public class InsertionSort {
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6 };
        System.out.println("Array before sorting:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Array after sorting:");
        printArray(arr)
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// Merge Sort is a popular sorting algorithm that follows the divide-and-conquer strategy.
// It divides the array into two halves, recursively sorts the sub-arrays, and then merges them to produce the final sorted array.
// It is efficient and stable, making it suitable for sorting large datasets.

// Imagine you have a deck of cards that you want to sort.
// You could use Merge Sort by dividing the deck into two halves, sorting each half separately, and then merging them back together in sorted order.
// This is similar to how you might sort a stack of papers by dividing them into smaller piles, sorting each pile, and then merging them back together.

public class MergeSort {
    // Merge two sorted sub-arrays arr[l..m] and arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create two temporary arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i]
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j]
        }

        // Merge the temporary arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ")
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        System.out.println("Given array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}

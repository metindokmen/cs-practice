// Quicksort is a comparison-based sorting algorithm that divides the input array into smallar sub-arrays, then recursively sorts the sub-arrays.
// Quicksort is often used in practice due to its efficiency and effectiveness on average.

// Consider arranging a group of students in ascending order of their heights.
// Quicksort would work by selecting a pivot student, arranging students taller than the pivot to the right and shorter to the left.
// This process continues recursively for the left and right subgroups until the entire group is sorted by height.

public class QuickSort {
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0l i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        ob.printArray(arr);
    }
}

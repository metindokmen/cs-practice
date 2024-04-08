// Shell Short algorithm is an extension of and an improvement over the Insertion Sort.
// It uses a sequence of increments (gaps) to sort elements.
// It starts by sorting pairs of elements far apart from each other, then gradually reduces the gap between elements to perform a final Insertion Sort.
// The idea is to move elements faster towards their expected position.

// Imagine you have a list of tasks to do, each with a priority level.
// You want to sort these tasks based on priority but prefer to tackle similar priority tasks together for efficiency.

public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                int temp = arr[i];

                // Shift earlier gap-sorted elements up until the correct location
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Place temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

}
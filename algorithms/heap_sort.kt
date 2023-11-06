// Heap Sort is a comparison-based sorting technique based on a Binary Heap data structure.
// It's similar to selection sort where we first find the maximum element and place the maximum element at the end.
// We repeat the same process for the remaining elements.

// Consider organizing a large number of documents by their importance and due date.
// A good approach would be to arrange them into a pile (heap) where the most urgent document is always on top.
// After you complete each document, you rearrange the pile to put the next most urgent document on top.
// This is similar to how Heap sort works with numbers.

fun heapify(arr: IntArray, n: Int, i: Int) {
    var largest = i
    val left = 2 * i + 1
    val right = 2 * i + 2

    if (left < n && arr[left] > arr[largest]) {
        largest = left
    }

    if (right < n && arr[right] > arr[largest]) {
        largest = right
    }

    if (largest != i) {
        arr[i] = arr[largest].also { arr[largest] = arr[i] }
        heapify(arr, n, largest)
    }
}

fun heapSort(arr: IntArray) {
    val n = arr.size

    for (i in n / 2 - 1 downTo 0) {
        heapify(arr, n, i)
    }

    for (i in n - 1 downTo 0) {
        arr[0] = arr[i].also { arr[i] = arr[0] }
        heapify(arr, i, 0)
    }
}

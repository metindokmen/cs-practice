// Linear Search is one of the simplest searching algorithms.
// It checks each element of a list in turn to find a specific value.
// It's best used on small or unsorted data sets
// because its performance is directly proportional to the size of the data set; the average performance is O(n).

// Imagine you're looking for a specific book in a small library.
// You start at one end of the shelf and examine each book in turn until you find the one you're looking for.
// This method, where you check every item sequentially until the desired one is found, is the essence of the Linear Search algorithm.

fun linearSearch(data: IntArray, valueToFind: Int): Int {
    for ((index, value) in data.withIndex()) {
        if (value == valueToFind) {
            return index // Return the index where the value is found
        }
    }
    return -1 // Return -1 if the value is not found
}

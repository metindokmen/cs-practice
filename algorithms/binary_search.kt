// Binary Search is a searching algorithm that finds the position of a target value within a sorted array or list.
// It compares the target value to the middle element of the array and eliminates half of the remaining search interval based on that comparison.
// The process continues until the value is found or the interval is empty.

// Imagine you're looking up a word in a dictionary. Instead of going through each word from the beginning to the end,
// you'd typically open the dictionary to a middle page and see if your word would lie before or after that page.
// You then split the relevant half into another half, and continue until you find your word.
// This method is faster than a linear search through every page, and is essentially a real-life binary search.

fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return -1
}

fun main() {
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val target = 7

    val result = binarySearch(numbers, target)

    if (result != -1) {
        println("Element $target found at index $result")
    } else {
        println("Element $target not found in the array.")
    }
}

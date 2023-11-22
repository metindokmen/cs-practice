// Cocktail Shaker Sort is a variation of Bubble Sort.
// While Bubble Sort only passes through the list in one direction (either up or down),
// Cocktail Shaker Sort passes alternately frmo bottom to top and then from top to bottom.
// This bidirectional approach helps in moving items to their positions faster,
// thus improving performance over the regular Bubble Sort in certain cases,
// especially where items at the end need to be moved to the beginning.

// Consider organizing a bookshelf where you want to order books by height.
// Starting from one end, you compare adjacent books, swapping them to put the taller one on the right.
// When you reach the other end, you reverse direction and do the same, this time moving the shorter book to the left.
// This back-and-forth process, akin to the movement of a cocktail shaker, continues until all books are in order.

fun cocktailShakerSort(arr: IntArray) {
    var swapped: Boolean
    do {
        swapped = false
        for (i in 0 until arr.size - 1) {
            if (arr[i] > arr[i + 1]) {
                arr[i] = arr[i + 1].also { arr[i + 1] = arr[i] }
                swapped = true
            }
        }
        if (!swapped) break

        swapped = false
        for (i in arr.size - 2 downTo 0) {
            if (arr[i] > arr[i + 1]) {
                arr[i] = arr[i + 1].also { arr[i + 1] = arr[i] }
                swapped = true
            }
        }
    } while (swapped)
}

fun main() {
    val arr = intArrayOf(5, 3, 4, 1, 2)
    cocktailShakerSort(arr)
    println("Sorted Array: ${arr.joinToString()}")
}

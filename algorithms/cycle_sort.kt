// Cycle Sort is an in-place and comparison-based sorting algorithm.
// It is theoretically optimal in the sense that it minimizes the number of writes to the original array.
// It works by considering each array element and then putting it at its correct position by rotating the cycle of elements involved.

// Imagine you're organizing a deck of cards where each card has a unique number and a specific order.
// Your task is to sort the deck such that each card is placed in its correct position with the minimum number of writes (or movements).
// Cycle Sort is an in-place sorting algorithm that is optimal in terms of the number of memory writes.
// It's especially useful when memory write is a costly operation.

fun cycleSort(arr: IntArray) {
    var writes = 0

    for (cycleStart in 0 until arr.lastIndex) {
        var item = arr[cycleStart]
        var pos = cycleStart
        for (i in cycleStart + 1 until arr.size) {
            if (arr[i] < item) {
                pos++
            }
        }

        if (pos == cycleStart) {
            continue
        }

        while (item == arr[pos]) {
            pos++
        }
        val temp = arr[pos]
        arr[pos] = item
        item = temp
        writes++

        while (pos != cycleStart) {
            pos = cycleStart
            for (i in cycleStart + 1 until arr.size) {
                if (arr[i] < item) {
                    pos++
                }
            }

            while (item == arr[pos]) {
                pos++
            }
            val temp2 = arr[pos]
            arr[pos] = item
            item = temp2
            writes++
        }
    }
}

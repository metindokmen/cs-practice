// A Binary Indexed Tree (also known as a Fenwick Tree) is a data structure providing efficient methods for calculation and manipulation of the prefix sums (cumulative sums) of a list of values.
// Its primary uses are in computational geometry and for solving problems that require updating elements and querying range-sums.

// Imagine you're managing a bookstore, and you're tracking the number of books sold each day.
// At the end of the month, you might want to know:

// 1. The total number of books sold between the 10th and 20th day.
// 2. Update the sales for a particular day.

// A Binary Indexed Tree can efficiently handle these operations.

class BinaryIndexedTree(size: Int) {
    private val tree = IntArray(size + 1)

    fun update(index: Int, value: Int) {
        var i = index + 1
        while (i < tree.size) {
            tree[i] += value
            i += i and -i // Move to the parent index
        }
    }
}
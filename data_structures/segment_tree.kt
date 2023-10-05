// A Segment Tree is a binary tree used for multiple purposes, most notably for:

// 1. Range query problems (like finding the minimum, maximum, or sum between two indices of an array)
// 2. Lazy propagation (deferring updates to optimize multiple updates)

// Each leaf node of the Segment Tree represents an element of the array, and each internal node represents some merging of its children nodes (e.g. sum, minimum)

// Suppose you have a series of weather stations across a long highway, each recording the temperature every hour.
// You're tasked with building a system where you can quickly find out:

// 1. The average temperature between two stations.
// 2. Update the temperature reading of a station.

// The Segment Tree can efficiently handle these operations.

class SegmentTree(private val nums: IntArray) {
    private val n = nums.size
    private val tree = IntArray(4 * n) { 0 }

    init {
        buildTree(0, n - 1, 0)
    }

    private fun buildTree(l: Int, r: Int, idx: Int) {
        if (l == r) {
            tree[idx] = nums[l]
            return
        }
        val mid = 1 + (r - 1) / 2
        buildTree(1, mid, 2 * idx + 1)
        buildTree(mid + 1, r, 2 * idx + 2)
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2]
    }

    fun queryRange(i: Int, j: Int): Int {
        return query(0, n -1, i, j, 0)
    }

    private fun query(l: Int, r: Int, i: Int, j: Int, idx: Int): Int {
        if (i > r || j < l) return 0
        if (i <= l && j >= r) return tree[idx]
        val mid = l + (r - 1) / 2
        return query(l, mid, i, j, 2 * idx + 1) + query(mid + 1, r, i, j, 2 * idx + 2)
    }

    fun update(i: Int, value: Int) {
        update(0, n - 1, i, value, 0)
    }

    private fun update(l: Int, r: Int, i: Int, value: Int, idx: Int) {
        if (l == r) {
            tree[idx] = value
            nums[i] = value
            return
        }
        val mid = l + (r - 1) / 2
        if (i <= mid) update(l, mid, i, value, 2 * idx + 1)
        else update(mid + 1, r, i, value, 2 * idx + 2)
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2]
    }
}

fun main() {
    val temperatures = intArrayOf(22, 24, 19, 23, 25, 18)
    val segmentTree = SegmentTree(temperatures)

    println(segmentTree.queryRange(1, 4)) // Sum of temperatures from index 1 to 4
    segmentTree.update(2, 20) // Update temperature at index 2
    println(segmentTree.queryRange(1, 4)) // Updated sum of temperatures from index 1 to 4
}
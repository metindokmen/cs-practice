// A Sparse Table is a data structure used primarily for range query problems, especially when the array is static (no updates).
// Once the table is built, it allows for constant-time range queries, making it useful for problems like finding the minimum or maximum value in a given subarray.

// Imagine you're analyzing stock prices over several days, and you want to quickly determine the hgihest price in any given range of days.
// Building a Sparse Table on the stock prices can allow you to query the maximum price in any range of days in constant time.

class SparseTable(private val arr: IntArray) {
    private val n = arr.size
    private val logN = (Math.log(n.toDouble()) / Math.log(2.0)).toInt() + 1
    private val table: Array<IntArray> = Array(n) { IntArray(logN) }

    init {
        build()
    }

    private fun build() {
        for (i in 0 until n) {
            table[i][0] = arr[i]
        }
        for (j in 1 until logN) {
            for (i in 0 until n) {
                if (i + (1 shl j) <= n) {
                    table[i][j] = maxOf(table[i][j - 1], table[i + (1 shl (j - 1))][j - 1])
                }
            }
        }
    }

    fun queryMax(left: Int, right: Int): Int {
        val len = right - left + 1
        val k = (Math.log(len.toDouble()) / Math.log(2.0)).toInt()
        return maxOf(table[left][k], table[right - (1 shl k) + 1][k])
    }
}

fun main() {
    val stockPrices = intArrayOf(100, 113, 110, 85, 105, 102, 86, 63, 81, 101)
    val sparseTable = SparseTable(stockPrices)

    println(sparseTable.queryMax(0, 4)) // Maximum stock price from day 0 to day 4 -> 113
    println(sparseTable.queryMax(3, 9)) // Maximum stock price from day 3 to day 9 -> 105
}
// The knapsack problem is an optimization problem where you have a set of items, each with a weight and a value.
// You need to determine the number of each item to include in a knapsack so that the total weight doesn't exceed a given limit while maximizing the total value.

// Imagine you're packing for a hiking trip and can only carry a limited amount of weight in your backpack.
// You have several items, each with a specific weight and benefit (e.g. food provides energy, a tent provides shelter etc.).
// You want to maximize the benefit you'll get from the items you bring without overloading your backpack.

fun knapsack(values: IntArray, weights: IntArray, capacity: Int): Int {
    val n = values.size
    val dp = Array(n + 1) { IntArray(capacity + 1) }

    for (i in 1..n) {
        for (w in 1..capacity) {
            // If the weight of the current item is more than the capacity, we can't include it.
            if (weights[i - 1] > w) {
                dp[i][w] = dp[i - 1][w]
            } else {
                // Either include the current item or exclude it, and take the maximum value.
                dp[i][w] = maxOf(
                    values[i - 1] + dp[i - 1][w - weights[i - 1]],
                    dp[i - 1][w]
                )
            }
        }
    }

    return dp[n][capacity]
}

fun main() {
    val values = intArrayOf(60, 100, 120)
    val weights = intArrayOf(10, 20, 30)
    val capacity = 50

    println(knapsack(values, weights, capacity)) // Output: 220
}
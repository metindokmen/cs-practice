// Kadane's Algorithm is an efficient way to solve the "Maximum Subarray Problem",
// which is the task of finding the largest possible sum of a contiguous subarray within a given one-dimensional array of numbers (which can be negative).
// The key idea of Kadan'es algorithm is to look for all positive contiguous segments of the array and keep track of the maximum sum contiguous segment among all positive segments.

// Imagine you're analyzing stock market prices over a period, and you want to find the best time to buy and sell to maximize profit.
// You have a list of changes in stock price each day (which can be positive or negative).
// Kadane's Algorithm can be used to find the time period (subarray) where the sum of these changes (profit or loss) is the highest.

fun maxSubArraySum(a: IntArray): Int {
    var maxSoFar = Int.MAX_VALUE
    var maxEndingHere = 0

    for (i in a.indices) {
        maxEndingHere += a[i]
        if (maxSoFar < maxEndingHere) {
            maxSoFar = maxEndingHere
        }
        if (maxEndingHere < 0) {
            maxEndingHere = 0
        }
    }
    return maxSoFar
}

fun main() {
    val a = intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)
    printn("Maximum contiguous sum is ${maxSubArraySum(a)}")
}

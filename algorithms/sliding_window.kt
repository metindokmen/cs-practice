// The Sliding Window algorithm is a method for keeping track of a subset of data in a larger dataset.
// It involves creating a 'window' which can either be a fixed size or flexible, that moves through the data to examine different subsets of elements.
// This technique is useful for solving array/string problems efficiently, such as finding the longest substring without repeating characters, maximum sum subarray of size 'k', or smallest subarray with a given sum.

// Suppose you're analyzing stock prices, and you want to find the maximum profit you can by buying and selling once within a given number of days.
// Using the Sliding Window technique, you can keep track of the minimum price seen so far and the maximum profit that can be made each day as you move through the price list.

fun maxSumSubarrayOfSizeK(arr: IntArray, k: Int): Int {
    var maxSum = 0
    var windowSum = 0
    var windowStart = 0

    for (windowEnd in arr.indices) {
        windowSum += arr[windowEnd] // Add the next element to the window

        // Slide the window if we've hit the size 'k'
        if (windowEnd >= k - 1) {
            maxSum = maxOf(maxSum, windowSum) // Update the maximum sum if needed
            windowSum -= arr[windowStart]     // Subtract the element going out of the window
            windowStart++                     // Slide the window ahead
        }
    }
}

fun main() {
    val stockPrices = intArrayOf(100, 180, 260, 310, 40, 535, 695)
    val k = 3
    println("Maximum profit for $k days is: ${maxSumSubarrayOfSizeK(stockPrices, k)}")
}

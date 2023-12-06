// The Longest Increasing Subsequence is a classic problem in computer science that seeks to find the length of the longest subsequence of a given sequence in which the elements are in sorted, increasing order.
// This problem has applications in numerous fields, including bioinformatics and stock market analysis.

// Imagine you're a teacher who has recorded the grades of a student throughout the year, and you want to analyze the longest period of consistent improvement in the student's performance.
// This can be modeled as finding the longest increasing subsequence within a sequence of grades.

fun lenghtOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val dp = IntArray(nums.size) { 1 }

    for (i in nums.indices) {
        for (j in 0 until i) {
            if (nums[j] < nums[i]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    return dp.maxOrNull() ?: 1
}

fun main() {
    val grades = intArrayOf(2, 5, 3, 7, 11, 8, 10, 13, 6)
    println("The longest period of consistent improvement is ${lenghtOfLIS(grades)} grading periods.")
}

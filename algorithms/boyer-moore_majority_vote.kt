// The Boyer-Moore Majority Vote Algorithm iterates through the array and maintains a candidate variable along with a count variable.
// It scans each element of the array and updates the candidate and count based on certain conditions.
// At the end of the iteration, the algorithm returns the candidate as the majority element if it exists.

// Imagine you are organizing a voting process where people are voting for different candidates.
// Boyer-Moore Majority Vote Algorithm can help identify the candidate who received more than half of the total votes, simplifying the process of determining the winner.

fun majorityElement(nums: IntArray): Int {
    var candidate = 0 // Potential majority element
    var count = 0 // Counter for the potential majority element

    // Find potential candidate for the majority element
    for (num in nums) {
        if (count == 0) {
            candidate = num
            count++
        } else if (candidate == num) {
            count++
        } else {
            count--
        }
    }

    // Verify if the candidate is the majority element
    count = 0
    for (num in nums) {
        if (num == candidate) {
            count++
        }
    }

    return if (count > nums.size / 2) candidate else -1 // Return majority element or -1 if not found
}

fun main() {
    val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
    val majority = majorityElement(nums)
    if (majority != -1) {
        println("Majority element: $majority")
    } else {
        println("Majority element does not exist")
    }
}

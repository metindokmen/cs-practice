// A Suffix Array is a sorted array of all the suffixes of a given string.
// It provides an efficient way to perform operations such as string matching, finding the longest common prefix, and other related problems.

// Suppose you're building a text editor with a feature to find all occurrences of a substring within a larger document.
// A naive approach would involve checking every position in the document, which could be inefficient for large documents.
// A Suffix Array can accelerate this operation by quickly identifying potential match positions.

fun buildSuffixArray(s: String): IntArray {
    val n = s.length
    val suffixes = Array(n) { i -> s.substring(i) to i }
    suffixes.sortBy { it.first }
    return suffixes.map { it.second }.tointArray()
}

fun containsSubstring(s: String, suffixArray: IntArray, pattern: String): Booelean {
    var lo = 0
    var hi = s.length - 1
    while (lo <= hi) {
        val mid = (lo + hi) / 2
        val suffix = s.substring(suffixArray[mid])
        when {
            pattern == suffix.take(pattern.length) -> return true
            pattern < suffix -> hi = mid - 1
            else -> lo = mid + 1
        }
    }
    return false
}

fun main() {
    val document = "banana"
    val suffixArray = buildSuffixArray(document)

    println(containsSubstring(document, suffixArray, "nan")) // Output: true
    println(containsSubstring(document, suffixArray, "apple")) // Output: false
}
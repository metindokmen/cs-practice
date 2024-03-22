// Longest Common Substring algorithm is used to find the longest substring that is present in two given strings.

// Suppose you have two texts, one representing a document and another representing a summary.
// You want to find the longest section of the document that appears in the summary.
// This could help identify the most important parts that are highlighted in the summary.

fun longestCommonSubstring(text1: String, text2: String): String {
    val m = text1.length
    val n = text2.length
    val dp = Array(m + 1) { IntArray(n + 1) }
    var maxLength = 0
    var endIndex = 0

    for (i in 1..m) {
        for (j in 1..n) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j]
                    endIndex = 1
                }
            } else {
                dp[i][j] = 0
            }
        }
    }

    return text1.substring(endIndex - maxLength, endIndex)
}

fun main() {
    val text1 = "dynamic programming"
    val text2 = "programmer"
    println("Longest Common Substring: ${longestCommonSubstring(text1, text2)}")
}

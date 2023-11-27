// Manacher's Algorithm is an efficient method to find the longest palindromic substring in linear time.
// Traditional approaches might have quadratic or even cubic time complexity, but Manacher's Algorithm accomplishes this in O(n) time, making it much more suitable for long strings.

// Imagine you're developing a word game where players need to find the longest palindromic substring within a given string.
// A palindrome is a word, phrase, number, or other sequences of characters that reads the same forward and backward (ignoring spaces, punctuation, and capitalization).
// For example, in the string "abcbadad", the longest palindromic substring is "bcacb".

fun longestPalindromicSubstring(s: String): String {
    val transformed = "#${s.toCharArray().joinToString("#")}{#}"
    val p = IntArray(transformed.length)
    var center = 0
    var right = 0

    for (i in transformed.indices) {
        val mirror = 2 * center - 1
        if (i < right) {
            p[i] = minOf(right - i, p[mirror])
        }

        var a = i + p[i] + 1
        var b = i - p[i] - 1
        while (a < transformed.length && b >= 0 && transformed[a] == transformed[b]) {
            p[i]++
            a++
            b--
        }

        if (i + p[i] > right) {
            center = i
            right = i + p[i]
        }
    }

    val (maxLen, centerIndex) = p.withIndex().maxByOrNull { it.value } ?: return ""
    val start = (centerIndex - maxLen) / 2
    return s.substring(start, start + maxLen)
}

// The Z-Algorithm is a linear-time string matching algorithm that identifies occurences of a pattern within a text.
// It constructs an array, Z, where each entry Z[i] represents the length of the longest substring starting from i that is also a prefix of the text.
// This array is then used to locate occurrences of the pattern within the text.

// Imagine you are developing a plagiarism detection tool for academic papers.
// Your tool needs to quickly find occurrences of certain phrases or sentences within a large document.
// This is where string matching algorithms like the Z-Algorithm come into play.

fun zAlgorithm(s: String): IntArray {
    val n = s.length
    val z = intArray(n)
    var l = 0
    var r = 0
    for (i in 1 until n) {
        if (i <= r) {
            z[i] = minOf(z[i - l], r - i + 1)
        }

        while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
            z[i]++
        }
        if (i + z[i] - 1 > r) {
            l = i
            r = i + z[i] - 1
        }
    }
    return z
}

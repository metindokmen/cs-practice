// KMP (Knuth-Morris-Pratt) Algorithm is an efficient string searching (or substring searching) algorithm that processes the pattern itself to determine how much of the comparison can be skipped.
// It pre-processes the pattern to create a `lps` (Longest Prefix which is also Suffix) array that helps in skipping characters while matching.

// Imagine you are reading a book and you want to find a particular word or phrase in it.
// Rather than reading every word from the start every time you want to find a match,
// you can use the KMP algorithm which efficiently skips portions of the text to improve the search.

fun KMPSearch(text: String, pattern: String): List<Int> {
    val lps = computeLPSArray(pattern)
    val indices = mutableListOf<Int>()

    var i = 0 // Index for text[]
    var j = 0 // Index for pattern[]
    while (i < text.length) {
        if (pattern[j] == text[i]) {
            i++
            j++
        }
        if (j == pattern.length) {
            indices.add(i - j)
            j = lps[j - 1]
        } else if (i < text.length && pattern[j] != text[i]) {
            if (j != 0) {
                j = lps[j - 1]
            } else {
                i++
            }
        }
    }
    return indices
}

fun computeLPSArray(pattern: String): IntArray {
    val n = pattern.length
    val lps = IntArray(n)
    var length = 0
    var i = 1
    lps[0] = 0

    while (i < n) {
        if (pattern[i] == pattern[length]) {
            length++
            lps[i] = length
            i++
        } else {
            if (length != 0) {
                length = lps[length - 1]
            } else {
                lps[i] = length
                i++
            }
        }
    }
    return lps
}

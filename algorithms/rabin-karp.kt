// The Rabin-Karp algorithm is a string-searching algorithm that uses hashing to find any one of a set of pattern strings in a text.
// It works by calculating a hash value for the pattern and for each substring of the text of the same lenght as the pattern.
// If the hash values match, the algorithm then checks if the actual substring and the pattern are identical.
// This avoids the need for character-by-character comparisons in most cases.

// Imagine you're trying to find a particular word or phrase in a long document.
// Instead of comparing the search string to every substring of the document (which would be time-consuming),
// you calculate a hash of the search string and then look for matches of this hash within the document.
// This is the principle behind the Rabin-Karp algorithm.

fun rabinKarp(text: String, pattern: String): Int {
    val m = pattern.length
    val n = text.length
    val prime = 101
    var patternHash = 0
    var textHash = 0
    var h = 1

    // The value of h would be "pow(d, M-1)%q"
    for (i in 0 until m - 1) {
        h = (h * 256) % prime
    }

    // Calculate the hash value of pattern and first window of text
    for (i in 0 until m) {
        patternHash = (256 * patternHash + pattern[i].toInt()) % prime
        textHash = (256 * textHash + text[i].toInt()) % prime
    }

    // Slide the pattern over text one by one
    for (i in 0..n - m) {
        if (patternHash == textHash) {
            var j = 0
            while (j < m) {
                if (text[i + j] != pattern[j]) break
                j++
            }
            if (j == m) return i
        }

        if (i < n - m) {
            textHash = (256 * (textHash - text[i].toInt() * h) + text[i + m].toInt()) % prime
            if (textHash < 0) textHash += prime
        }
    }
    return -1
}

fun main() {
    val text = "ABCCDDAEFG"
    val pattern = "CDD"
    val result = rabinKarp(text, pattern)
    if (result != -1) {
        println("Pattern found at index: $result")
    } else {
        println("Pattern not found")
    }
}

// The boyer-Moore algorithm is an efficient string searching algorithm that skips sections of the text to be searched.
// It preprocesses the pattern to create two different heuristics - the bad character heuristic and the good suffix heuristic.
// These heuristics allow the algorithm to skip over positions of the text where the pattern cannot possible match, leading to fewer comparisons than simpler algorithms,
// especially when the pattern length is long.

// Imagine you're going through a large book looking for a specific word or phrase.
// Instead of reading every word from start to finish, you might skip ahead multiple characters at a time, especially if you know the word you're looking for is quite distinct.
// The Boyer-Moore algorithm uses a similar idea to efficiently find a substring in a larger string by skipping sections of the text that cannot possibly contain the search string.

fun boyerMooreSearch(text: String, pattern: String): Int {
    val m = pattern.length
    val n = text.length

    val badChar = IntArray(256) { -1 }
    for (i in 0 until m) {
        badChar[pattern[i].toInt()] = i
    }

    var shift = 0
    while (shift <= n - m) {
        var j = m - 1

        // Decrease j while characters of pattern and text are matching
        while (j >= 0 && pattern[j] == text[shift + j]) {
            j--
        }

        if (j < 0) {
            return shift // Pattern found at shift
        } else {
            // Shift the pattern so that the bad character in text
            // aligns with the last occurrence of it in pattern.
            shift += maxOf(1, j - badChar[text[shift + j].toInt()])
        }
    }
    return -1 // Pattern not found
}

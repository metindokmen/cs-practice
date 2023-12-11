// Booth's Algorithm is used for finding the lexicogrphical smallest rotation of a string.
// It's an efficient way to solve problems related to circular strings, where the end of the string is conceptually connected to the beginning.

// Suppose you are developing a feature in a music app to identify a song from a snippet of its lyrics.
// The lyrics are circular in nature, meaning the end of the string is connected to the beginning (like in a loop).
// Booth's Algorithm allows you to efficiently find the lexicographically smallest string rotation, which can be used for circular string matching.

fun leastLexicographicRotation(s: String): String {
    val concatenated = s + s
    val len = s.length
    val f = IntArray(2 * len) { -1 }
    var k = 0

    for (j in 1 until 2 * len) {
        var sj = concatenated[j]
        var i = f[j - k - 1]
        while (i != -1 && sj != concatenated[k + i + 1]) {
            if (sj < concatenated[k + i + 1]) {
                k = j - i - 1
            }
            i = f[i]
        }
        if (sj != concatenated[k + i + 1]) {
            if (sj < concatenated[k]) k = j
            f[j - k] = -1
        } else {
            f[j - k] = i + 1
        }
    }

    return concatenated.substring(k, k + len)
}

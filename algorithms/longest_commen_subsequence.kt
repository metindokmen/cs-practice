// The LCS algorithm is used in computer science to find the longest subsequence common to all sequences in a set of sequences (often just wo sequences).
// A subsequence is a sequence that appears in the same relative order, but not necessarily contiguously.
// The algorithm is useful in many applications, such as diff tools, bioinformatics for DNA sequencing, and in naturel language processing.

// Suppose you're working with two versions of a text document and you want to find the longest sequence of words (or characters) that appears in both versions.
// This is a common problem in version control systems and text comparison tools.
// The Longest Commong Subsequence algorithm can efficiently find this sequence.

fun lcs(X: String, Y: String): String {
    val m = X.length
    val n = Y.length
    val L = Array(m + 1) { IntArray(n + 1) }

    // Building the L[m+1][n+1] in bottom-up fashion
    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 || j == 0) {
                L[i][j] = 0
            } else if (X[i - 1] == y[j - 1]) {
                L[i][j] = L[i - 1][j - 1] + 1
            } else {
                L[i][j] = maxOf(L[i - 1][j], L[i][j - 1])
            }
        }
    }

    // Reconstructing the LCS from L
    var index = L[m][n]
    var lcs = CharArray(index)

    var i = m
    var j = n
    while (i > 0 && j > 0) {
        if (X[i - 1] == Y[j - 1]) {
            lcs[--index] = X[i - 1]
            i--
            j--
        } else if (L[i - 1][j] > L[i][j - 1]) {
            i--
        } else {
            j--
        }
    }

    return String(lcs)
}

fun main() {
    val X = "AGGTAB"
    val Y = "GXTXAYB"
    println("Longest Common Sequence: ${lcs(X, Y)}")
}

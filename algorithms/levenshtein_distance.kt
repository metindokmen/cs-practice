// The Levenshtein Distance Algorithm calculates the minimum number of single-character edits required to change one string into another.
// This metric is useful in applications where text strings need to be compared in a flexible manner, accounting for possible typos.

// Consider a spell checker that suggests corrections for a misspelled word.
// The algorithm calculates how many single-character edits (insertions, deletions, or substitutions) are necessary to change one word into another,
// helping the spell checker determine the most similar correct words to suggest.

fun levenshetein(a: String, b: String): Int {
    val dp = Array(a.length + 1) { IntArray(b.length + 1) }

    for (i in 0..a.length) {
        for (j in 0..b.length) {
            when {
                i == 0 -> dp[i][j] = j // A is empty, all insertions
                j == 0 -> dp[i][j] = i // B is empty, all deletions
                else -> {
                    val cost = if (a[i - 1]) == b[j - 1] 0 else 1
                    dp[i][j] = minOf(
                        dp[i - 1][j] + 1, // Deletion
                        dp[i][j - 1] + 1, // Insertion
                        dp[i - 1][j - 1] + cost // Substitution
                    )
                }
            }
        }
    }

    return dp[a.length][b.length]
}

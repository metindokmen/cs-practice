// The Smith-Waterman algorithm is an extension of the Needleman-Wunsch algorithm for global sequence alignment.
// It finds the optimal local alignment between two sequences by maximizing a similarity score and allowing gaps (insertions and deletions) within the sequences.

// 1. Initialization: Create a matrix representing the alignment scores between all pairs of elements in the sequences. Initialize the first row and column with zeros.
// 2. Scoring Scheme: Define a scoring scheme that assigns scores for matches, mismatches, and gap penalties.
// 3. Dynamic Programming: Fill in the matrix by recursively calculating the alignment scores based on three possible operations: match/mismatch, insertion, and deletion. Each cell in the matrix represents the maximum score attainable at that position.
// 4. Traceback: Trace back from the highest-scoring cell to find the optimal alignment path. This path represents the local alignment with the highest similarity score.

// Consider you have two DNA sequences and you want to find the optimal alignment between them, considering mutations, insertions, and deletions.
// The Smith-Waterman algorithm can help you find the best local alignment, highlighting the regions of similarity and dissimilarity between the sequences.

fun smithWaterman(sequence1: String, sequence2: String, matchScore: Int, mismatchScore: Int, gapPenalty: Int): Int {
    val matrix = Array(sequence1.length + 1) { IntArray(sequence2.length + 1) }
    var maxScore = 0

    for (i in 1..sequence1.length) {
        for (j in 1..sequence2.length) {
            val match = if (sequence1[i - 1] == sequence2[j - 1]) matchScore else mismatchScore
            matrix[i][j] = maxOf(
                0,
                matrix[i - 1][j - 1] + match, // match/mismatch
                matrix[i - 1][j] - gapPenalty, // deletion
                matrix[i][j - 1] - gapPenalty // insertion
            )
            maxScore = maxOf(maxScore, matrix[i][j])
        }
    }

    return maxScore
}

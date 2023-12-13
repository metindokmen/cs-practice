// Backtracking is an algorithm paradigm that tries different solutions until it finds a solution that works.
// It is used when you need to find all (or some) solutions to a problem that satisfies specific constraints.
// Backtracking incrementally builds candidates for the solutions and abandons a candidate ("backtracks") as soon as it determines that this candidate cannot possible be completed to a valid solution.

// Consider a puzzle where you need to place N queens on an NxN chessboard so that no two queens threaten each other.
// This means no two queens can be in the same row, column, or diagonal.
// The N-Queens Problem is a classic example where the backtracking algorithm is used to systematically explore the possible arrangements of queens on the board.

fun isSafe(board: Array<IntArray>, row: Int, col: Int, n: Int): Boolean {
    for (i in 0 until col) {
        if (board[row][i] == 1) return false
    }

    var i = row
    var j = col
    while (i >= 0 && j >= 0) {
        if (board[i][j] == 1) return false
        i--
        j--
    }

    i = row
    j = col
    while (j >= 0 && i < n) {
        if (board[i][j] == 1) return false
        i++
        j--
    }

    return true
}

fun solveNQUtil(board: Array<IntArray>, col: Int, n: Int): Boolean {
    if (col >= n) return true

    for (i in 0 until n) {
        if (isSafe(board, i, col, n)) {
            board[i][col] = 1

            if (solveNQUtil(board, col + 1, n)) return true

            board[i][col] = 0 // BACKTRACK
        }
    }
    return false
}

fun solveNQ(n: Int) {
    val board = Array(n) { IntArray(n) { 0 } }

    if (!solveNQUtil(board, 0, n)) {
        println("Solution does not exist")
        return
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            println("${board[i][j]}")
        }
        println()
    }
}

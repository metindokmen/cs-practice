// Strassen's Algorithm is an efficient algorithm used for matrix multiplication.
// It is particularly faster than the standard algorithm for large matrices.
// The key idea behind Strassen's algorithm is that it reduces the number of recursive calls for multiplying submatrices from 8 (in the standard algorithm) to 7,
// using clever additions and subtractions of those products.
// This reduction provides a better run-time complexity.

// Imagine you're working with 3D graphics in a video game, where you need to perform numerous matrix transformations - scaling, rotating, and translationg objects in the game world.
// Efficient matrix multiplication becomes crucial for rendering these objects quickly, especially as the complexity of the scene increases.
// Strassen's algorithm can be used here to optimize these matrix multiplication operations.

typealias Matrix = Array<Array<Int>>

fun addMatrix(A: Matrix, B: Matrix): Matrix {
    val n = A.size
    val sum = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            sum[i][j] = A[i][j] + B[i][j]
        }
    }

    return sum
}

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

fun subtractMatrix(A: Matrix, B: Matrix): Matrix {
    val n = A.size
    val diff = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            diff[i][j] = A[i][j] - B[i][j]
        }
    }
    return diff
}

fun strasssen(A: Matrix, B: Matrix): Matrix {
    val n = A.size
    if (n == 1) {
        return arrayOf(arrayOf(A[0][0] * B[0][0]))
    }

    val mid = n / 2
    val a11 = Array(mid) { i -> Array(mid) { j -> A[i][j] } }
    val a12 = Array(mid) { i -> Array(mid) { j -> A[i][j + mid] } }
    val a21 = Array(mid) { i -> Array(mid) { j -> A[i + mid][j] } }
    val a22 = Array(mid) { i -> Array(mid) { j -> A[i + mid][j + mid] } }

    val b11 = Array(mid) { i -> Array(mid) { j -> B[i][j] } }
    val b12 = Array(mid) { i -> Array(mid) { j -> B[i][j + mid] } }
    val b21 = Array(mid) { i -> Array(mid) { j -> B[i + mid][j] } }
    val b22 = Array(mid) { i -> Array(mid) { j -> B[i + mid][j + mid] } }

    val m1 = strassen(addMatrix(a11, a22), addMatrix(b11, b22))
    val m2 = strassen(addMatrix(a21, a22), b11)
    val m3 = strassen(a11, subtractMatrix(b12, b22))
    val m4 = strassen(a22, subtractMatrix(b21, b11))
    val m5 = strassen(addMatrix(a11, a12), b22)
    val m6 = strassen(subtractMatrix(a21, a11), addMatrix(b11, b12))
    val m7 = strassen(subtractMatrix(a12, a22), addMatrix(b21, b22))

    val c11 = addMatrix(subtractMatrix(addMatrix(m1, m4), m5), m7)
    val c12 = addMatrix(m3, m5)
    val c21 = addMatrix(m2, m4)
    val c22 = addMatrix(subtractMatrix(addMatrix(m1, m3), m2), m6)

    val C = Array(n) { Array(n) { 0 } }
    for (i in 0 until mid) {
        for (j in 0 until mid) {
            C[i][j] = c11[i][j]
            C[i][j + mid] = c12[i][j]
            C[i + mid][j] = c21[i][j]
            C[i + mid][j + mid] = c22[i][j]
        }
    }
    return C
}

fun main() {
    val A = arrayOf(
        arrayOf(1, 2),
        arrayOf(3, 4)
    )

    val B = arrayOf(
        arrayOf(5, 6),
        arrayOf(7, 8)
    )

    val product = strasssen(A, B)

    for (row in product) {
        println(row.joinToString(" "))
    }
}

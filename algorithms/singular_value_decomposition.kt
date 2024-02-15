// SVD is a matrix factorization technique that decomposes a matrix A into three matrices U, Σ, and V^T, such that:

// A=UΣV^T

// U is an m x m orthogonal matrix containing the left singular vectors.
// Σ is an m x n diagonal matrix containing the singular values in descending order.
// V^T is an n×n orthogonal matrix containing the right singular vectors.

// Imagine you have a large dataset representing user ratings for different movies in a movie recommendation system.
// Each row represents a user, each column represents a movie, and the entries represent the ratings.
// SVD can be used to decompose this matrix into three matrices representing latent factors such as user preferences and movie features.
// By approximating the original matrix with a lower-rank approximation obtained from SVD, you can effectively perform dimensionality reduction while preserving the essential information needed for accurate recommendations.

import org.apache.commons.math3.linear.SingularValueDecomposition
import org.apache.commons.math3.linear.Array2DRowRealMatrix

fun svd(matrix: Array<Array<Double>>): Triple<Array<Array<Double>>, Array<Double>, Array<Array<Double>>> {
    val realMatrix = Array2DRowRealMatrix(matrix.map { it.toDoubleArray() }.toTypedArray())
    val svd = SingularValueDecomposition(realMatrix)
    val u = svd.u.data
    val sigma = svd.singularValues
    val vt = svd.v.transpose().data
    return Triple(u. sigma, vt)
}

fun main() {
    val matrix = arrayOf(
        arrayOf(1.0, 2.0, 3.0),
        arrayOf(4.0, 5.0, 6.0),
        arrayOf(7.0, 8.0, 9.0)
    )

    val (u, sigma, vt) = svd(matrix)

    println("Left Singular Vectors (U):")
    u.forEach { row -> println(row.joinToString(" ")) }

    println("\nSingular Values (Σ):")
    println(sigma.joinToString(" "))

    println("\nRight Singular Vectors (V^T):")
    vt.forEach { row -> println(row.joinToString(" ")) }
}

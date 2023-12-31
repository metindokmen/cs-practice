// The Gauss-Seidel Method is an iterative technique used for solving a system of linear equations.
// It is particularly useful for large systems where direct methods are not feasible.
// The method assumes the system is in the form Ax=b and iteratively approximates the solution x.
// It is an improvement over the Jacobi method in terms of convergence speed.

// Imagine you're an engineer working on a simulation of physical forces in a building structure.
// Your task involves solving a large system of linear equations that represent varius physical forces and constratins.
// Direct methods like Gaussian elimination can be computationally expensive for large systems.
// The Gauss-Seidel Method provides an iterative approach to approximate the solution more efficiently.

fun gaussSeidel(a: Array<DoubleArray>, b: DoubleArray, numIterations: Int): DoubleArray {
    val n = a.size
    val x = DoubleArray(n)

    for (iteration in 0 until numIterations) {
        for (i in 0 until n) {
            var sum = b[i]
            for (j in 0 until n) {
                if (i != j) {
                    sum -= a[i][j] * x[j]
                }
            }
            x[i] = sum / a[i][i]
        }
    }
    return x
}

fun main() {
    val a = arrayOf(
        doubleArrayOf(4.0, 1.0, -1.0),
        doubleArrayOf(2.0, 7.0, 1.0),
        doubleArrayOf(1.0, -3.0, 12.0)
    )
    val b = doubleArrayOf(3.0, 19.0, 31.0)
    val numIterations = 10

    val solution = gaussSeidel(a, b, numIterations)
    println("Solution: ${solution.joinToString(", ")}")
}

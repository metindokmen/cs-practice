// The Linear Congruential Generator is one of the oldest and simplest algorithms for generating pseudorandom numbers.
// The algorithm works by following a linear formula: Xn+1​ = (a×Xn​+c) mod m

class LinearCongruentialGenerator(seed: Long) {
    private var current: Long = seed
    private val a = 1664525L
    private val c = 1013904223L
    private val m = (2L shl 31)

    fun nextInt(): Int {
        current = (a * current + c) % m
        return current.toInt()
    }
}

fun main() {
    val seed = System.currentTimeMillis() // Using current time as seed for randomness
    val lcg = linearCongruentialGenerator(seed)

    // Generate 10 random numbers
    repeat(10) {
        println(lcg.nextInt())
    }
}

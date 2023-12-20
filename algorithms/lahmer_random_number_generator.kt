// The Lehmer Random Number Generator is a type of linear congruential generator,
// one of the oldest and simplest methods for generating sequences of pseudorandom numbers.
// The generator works on the principle of taking the remainder of a linear equation to produce the next number in the sequence.

// Suppose you're developing a mobile game, and you need a reliable way to generate random numbers for various game mechanics, like determining loot drops or enemy behavior.
// A random number generator like Lehmer's can provide a sequence of pseudorandom numbers based on an initial seed.
// Such generators are crucial in games and simulations where controlled randomness is required.

class LehmerRNG(seed: Long) {
    private var current: Long = seed
    private val a = 48271L    // Multiplier
    private val m = 2147483647L  // Modulus (2^31 - 1, a prime number)

    fun nextInt(): Int {
        current = (a * current) % m
        return current.toInt()
    }
}

fun main() {
    val seed = 12345L  // Example seed
    val rng = LehmerRNG(seed)

    // Generate and print 10 random numbers
    for (i in 1..10) {
        println(rng.nextInt())
    }
}

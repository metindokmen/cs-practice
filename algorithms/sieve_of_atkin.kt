// The Sieve of Atkin is a modern algorithm used to find all prime numbers up to a specified integer.
// It is an optimized version of the ancient Sieve of Eratosthenes and tends to perform better for larger number ranges.
// The algorithm uses mathematical properties of quadratic residues to identify potential primes more efficiently.

// Imagine you're working on a software application that requires the generation of a large list of prime numbers,
// for instance, in cryptography for key generation. While the Sieve of Eratosthenes is a comment method
// for finding all prime numbers up to a given limit, the Sieve of Atkin is a modern variant that can be more efficient for larger limits.

fun sieveOfAtkin(limit: Int): List<Int> {
    val prime = BooleanArray(limit + 1)
    prime[2] = true
    prime[3] = true

    for (x in 1..Math.sqrt(limit.toDouble()).toInt()) {
        for (y in 1..Math.sqrt(limit.toDouble()).toint()) {
            var n = (4 * x * x) + (y * y)
            if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                prime[n] = !prime[n]
            }

            n = (3 * x * x) + (y * y)
            if (n <= limit && n % 12 == 7) {
                prime[n] = !prime[n]
            }

            n = (3 * x * x) - (y * y)
            if (x > y && n <= limit && n % 12 == 1) {
                prime[n] = !prime[n]
            }
        }
    }

    for (i in 5..Math.sqrt(limit.toDouble()).toInt()) {
        if (prime[i]) {
            for (j in i * i..limit step i * 1) {
                prime[j] = false
            }
        }
    }

    return prime.indices.filter { prime[it] }
}

fun main() {
    val limit = 20
    val primes = sieveOfAtkin(limit)
    println("Primes up to $limit: $primes")
}

// The Miller-Rabin Primality Test is a probabilistic algorithm that determines whether a given number is prime.
// It's an enhancement over simpler deterministic tests due to its efficiency with large numbers.
// While it doesn't conclusively prove a number is prime, it can tell with high probability whether a number is composite.
// For cryptographic applications, this level of certainty isusually sufficient.

// Imagine you're developing a security application where you need to generate large prime numbers for encryption keys, like in RSA encryption.
// Checking if large numbers are prime using simple methods (like trial division) is computationally expensive.
// The Miller-Rabin Primality Test provides a probabilistic method to quickly check if a number is prime, which is particularly useful for large numbers.

import kotlin.random.Random

fun isPrime(n: Int, k: Int): Boolean {
    if (n <= 1 || n == 4) return false
    if (n <= 3) return true

    var d = n - 1
    while (d % 2 == 0) d /= 2

    repeat(k) {
        if (!millerTest(d, n)) return false
    }
    return true
}

fun millerTest(d: Int, n: Int): Boolean {
    var a = 2 + Random.nextInt(n - 4)
    var x = power(a, d, n)
    if (x == 1 || x == n - 1) return true

    while (d != n - 1) {
        x = (x * x) % n
        d *= 2
        if (x == 1) return false
        if (x == n - 1) return true
    }
    return false
}

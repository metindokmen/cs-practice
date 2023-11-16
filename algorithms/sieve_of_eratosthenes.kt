// The Sieve of Eratosthenes is an ancient algorithm used to find all prime numbers up to any given limit.
// It does so by iteratively marking the multiples of each prime number starting from 2.
// The numbers which remain unmarked at the end of the algorithm are prime numbers.

// Imagine you're at a school fair and there's a game where you need to identify all prime numbers up to a certain number, say 100.
// One efficient way to do this would be to start with a list of all numbers from 2 to 100.
// First, you circle the number 2 (the smallest prime number) and cross out all multiples of 2.
// Then you move to the next uncrossed numbers, circle it (as it's a prime), and cross out all its multiples.
// You continue this process until you've circled all prime numbers up to 100.
// This process is very similar to how the Sieve of Eratosthenes algorithm identifies prime numbers.

fun sieveOfEratosthenes(n: Int): List<Int> {
    val prime = BooleanArray(n + 1) { true }
    var p = 2

    while (p * p <= n) {
        if (prime[p]) {
            for (i in p * p..n step p) {
                prime[i] = false
            }
        }
    }

    val primeNumbers = mutableListOf<Int>()
    for (i in 2..n) {
        if (prime[i]) {
            primeNumbers.add(i)
        }
    }
    return primeNumbers
}

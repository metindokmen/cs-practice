// Binary Exponentiation (also known as exponentiation by squaring) is an algorithm to calculate the power of a number in O(log n) time.
// It is significantly faster than the naive approach of multiplying the number n times which would take O(n) time.

// Imagine you are creating a finance application that needs to calculate compounded interest over a period of time which can be computed as A = P(1 + r/n)nt,
// where P is the principal amount, r is the annual interest rate, n is the number of times interest is compounded per year, and t is the time in years.
// Binary exponentiation can efficiently calculate powers like (1 + r/n)nt even for large nt.

fun binaryExponentiation(x: Long, n: Long, m: Long): Long {
    var x = x % m
    var n = n
    var result: Long = 1
    while (n > 0) {
        if (n and 1L == 1L) {
            result = result * x % m
        }
        x = x * x % m
        n = n shr 1
    }
    return result
}

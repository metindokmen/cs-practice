// The Euclidean Algorithm is an efficient method for computing the greatest common divisor (GCD) of two integers.
// It is based on the principle that the GCD of two numbers also divides their difference.
// By repeatedly subtracting the smaller number from the larger one, the algorithm eventually reduces this to the case where one of the two numbers is zero, at which point the other number is the GCD.

// Imagine you're a craftsman who needs to cut tiles for a floor.
// You want to find the largest square tile size that can be used to tile the floor withput cutting any tiles, given the length and width of the floor.
// The GCD of the floor's length and width will give you the size of the largest square tile that can be used.
// This is where the Euclidean Algorithm is useful.

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun main() {
    val length = 60
    val width = 48
    val tileSize = gcd(length, width)

    println("The largest square tile size for the floor is: $tileSize")
}

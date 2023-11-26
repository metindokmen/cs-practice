// Heap's Algorithm is used for generating all possible permutations of n objects.
// It was first proposed by B.R. Heap in 1963.
// The algorithm is efficient and requires only O(n!) time to generate all permutations.

// Imagine you're organizing a dinner party and want to decide the seating arrangment for your guests.
// You have a specific number of guests and want to consider every possible seating order to ensure the possible conversation dynamics.
// Heap's Algorithm can be used to efficiently generate all possible permutations of the guests' seating order.

fun <T> permute(elements: MutableList<T>, n: Int = elements.size) {
    if (n == 1) {
        println(elements)
    } else {
        for (i in 0 until n - 1) {
            permute(elements, n - 1)
            if (n % 2 == 0) {
                elements.swap(i, n - 1)
            } else {
                elements.swap(0, n - 1)
            }
        }
        permute(elements, n - 1)
    }
}

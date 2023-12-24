// The Rod Cutting Problem is a classic example of an optimization problem solved using Dynamic Programming.
// The idea is to make cuts at different positions and compare the total revenue obtained from those cuts, storing the results of sub-problems to avoid re-computation.

// Imagine you own a factory that cuts steel rods.
// The rods come in standard lengths, but your customers require rods of different lengths.
// Each length has a different price, and you need to cut the rods in a way that maximizes revenue.
// This is the Rod Cutting Problem, where you are given a rod of length n and a list of prices for rods of lengths 1 to n.
// You need to determine the optimal way to cut the rod into smallar rods to maximize profit.

fun rodCutting(prices: IntArray, length: Int): Int {
    val revenue = IntArray(length + 1)
    for (i in 1..length) {
        var maxVal = Int.MIN_VALUE
        for (j in 1..i) {
            maxVal = maxOf(maxVal, prices[j - 1] + revenue[i - j])
        }
        revenue[i] = maxVal
    }
    return revenue[length]
}

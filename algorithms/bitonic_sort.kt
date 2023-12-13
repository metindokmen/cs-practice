// Bitonic Sort is a parallel algorithm for sorting. It is also a comparison-based sorting algorithm and is used mainly in parallel computing.
// A sequence is called bitonic if it is a sequence of "x0​≤x1​≤...≤xk​≥xk+1​≥...≥xn−1" for some k (0 ≤ � k < � n), or a circular shift of such a sequence.
// Bitonic Sort first produces a bitonic sequence frmo the unsorted input, and then it sorts the bitonic sequence.

// Imagine you're managaing a large-scale, parallel processing system where you need to sort vast amounts of data quickly.
// In such a scenario, traditional sorting algorithms might not be efficient due to their sequential nature.
// Bitonic Sort, however, is designed for parallel processing, where multiple comparisons and swaps can be executed simultaneously,
// significantly reducing the sorting time.

fun compAndSwap(a: IntArray, i: Int, j: Int, dir: Int) {
    if (dir == (a[i] > a[j]).compareTo(false)) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }
}

fun bitonicMerge(a: IntArray, low: Int, cnt: Int, dir: Int) {
    if (cnt > 1) {
        val k = cnt / 2
        for (i in low until low + k) {
            compAndSwap(a, i, i + k, dir)
        }
        bitonicMerge(a, low, k, dir)
        bitonicMerge(a, low + k, k, dir)
    }
}

fun bitonicSort(a: IntArray, low: Int, cnt: Int, dir: Int) {
    if (cnt > 1) {
        val k = cnt / 2
        bitonicSort(a, low, k, 1)
        bitonicSort(a, low + k , k, 0)
        bitonicMerge(a, low, cnt, dir)
    }
}

fun sort(a: IntArray, up: Boolean) {
    bitonicSort(a, 0, a.size, if (up) 1 else 0)
}

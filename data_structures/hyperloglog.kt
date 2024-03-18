// HyperLogLog is a probabilistic data structure used for approximating the number of distinct elements in a multiset.

// 1. Concept:
// - HyperLogLog (HLL) is a probabilistic algorithm designed to estimate the cardinality (number of distinct elements) of a multiset with a high accuracy rate using minimal memory space.
// - It works by hashing elements of the multiset and maintaining a set of registers to estimate the number of leading zeros in the binary representation of hash values.

// 2. Structure:
// - HLL uses a set of registers (usually represented as an array) to store information about the leading zero count for hashed values.
// - The number of registers and the precision of the leading zero count determine the accuracy of the cardinality estimation.

// 3. Operations:
// - Add: When an element is encountered in the multiset, its hash value is computed, and the leading zero count is updated in the corresponding register.
// - Estimate: To estimate the cardinality, the harmonic mean of the register values is computed, and a correction factor is applied to account for bias introduced by register collisions.

import kotlin.math.ln

class HyperLogLog(private val precision: Int) {
    private val registers: IntArray = IntArray(1 shl precision)

    init {
        require(precision in 4..16) { "Precision must be in the range [4, 16]" }
    }

    fun add(element: String) {
        val hash = element.hashCode()
        val index = hash ushr (32 - precision)
        val leadingZeros = Integer.numberOfLeadingZeros(hash shl precision)
        registers[index] = maxOf(registers[index], leadingZeros)
    }

    fun estimate(): Double {
        val alpha = getAlpha(precision)
        val harmonicMean = calculateHarmonicMean()
        val cardinalityEstimate = alpha * (1 / harmonicMean)
        return cardinalityEstimate
    }

    private fun calculateHarmonicMean(): Double {
        var sum = 0.0
        for (register in registers) {
            sum += 1.0 / (1 shl register)
        }
        return sum
    }

    private fun getAlpha(precision: Int): Double {
        return when (precision) {
            4 -> 0.673
            5 -> 0.697
            6 -> 0.709
            else -> 0.7213 / (1 + 1.079 / (1 shl precision))
        }
    }
}

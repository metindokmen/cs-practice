// LOWESS fits multiple local weighted regressions to the data, assigning different weights to data points based on their proximity to the point being smoothed.
// It is particularly useful for capturing trends in noisy datasets.

// Consider monitoring the daily temperature changes.
// LOWESS can be applied to smooth the temperature data, providing a clearer trend by reducing noise caused by daily fluctuations.

class LowessExample(private val xValues: DoubleArray, private val yValues: DoubleArray, private val bandwith: Double) {

    fun performLowess(): DoubleArray {
        val smoothedValues = DoubleArray(xValues.size)

        for (i in xValues.indices) {
            val x = xValues[i]
            smoothedValues[i] = locallyWeightedRegression(x, xValues, yValues, bandwith)
        }

        return smoothedValues
    }

    private fun locallyWeightedRegression(x: Double, xValues: DoubleArray, yValues: DoubleArray, bandwidth: Double): Double {
        val weights = calculateWeights(x, xValues, bandwidth)

        var numerator = 0.0
        var denominator = 0.0

        for (i in xValues.indices) {
            val weight = weights[i]
            val diff = x - xValues[i]
            val kernel = tricubeKernel(diff / bandwidth)
            numerator += weight * yValues[i] * kernel
            denominator += weight * kernel
        }

        return numerator / denominator
    }

    private fun calculateWeights(x: Double, xValues: DoubleArray, bandwidth: Double): DoubleArray {
        val weights = DoubleArray(xValues.size)

        for (i in xValues.indices) {
            val diff = x - xValues[i]
            weights[i] = tricubeKernel(diff / bandwidth)
        }

        return weights
    }

    private fun tricubeKernel(u: Double): Double {
        val absU = Math.abs(u)
        return if (absU <= 1) {
            (1 - absU * absU * absU)
        } else 0.0
    }
}
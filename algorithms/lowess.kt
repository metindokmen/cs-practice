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

}
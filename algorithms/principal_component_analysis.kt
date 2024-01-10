// PCA aims to transform the original features into a new set of uncorrelated features, known as principal components.
// These components are ordered by the amount of varianca they capture in the data, allowing you to retain the most relevant information with fewer features.

// Imagine you have a dataset with numerous features, and you want to reduce its dimensionality while retaining as much relevant information as possible.
// PCA can be applied to identify the principal components, which are new features that capture the most significant variations in the data.
// This can be beneficial in various applications, such as image compression, facial recognition, and signal processing.

// The following dependency is to be added to the build.gradle file:
// implementation 'com.github.haifeng1:smile-core:2.5.0'

import smile.projection.PCA

data class DataPoint(val feature1: Double, val feature2: Double, val feature3: Double)

class PCAExample(private val dataPoints: List<DataPoint>) {
    fun applyPCA(newDataPoint: DataPoint): DoubleArray {
        val data = dataPoints.map { doubleArrayOf(it.feature1, it.feature2, it.feature3) }.toTypedArray()
        val pca = PCA(data)
        pca.setProjection(2) // Set the desired number of dimensions

        val transformedData = pca.project(doubleArrayOf(newDataPoint.feature1, newDataPoint.feature2, newDataPoint.feature3))
        return transformedData
    }
}

fun main() {
    val dataPoints = listOf(
        DataPoint(1.0, 2.0, 3.0),
        DataPoint(4.0, 5.0, 6.0),
        DataPoint(7.0, 8.0, 9.0)
        // Add more data points as needed
    )

    val newDataPoint = DataPoint(2.0, 3.0, 4.0)

    val pcaExample = PCAExample(dataPoints)
    val transformedData = pcaExample.applyPCA(newDataPoint)

    println("Original Data: ${doubleArrayOf(newDataPoint.feature1, newDataPoint.feature2, newDataPoint.feature3).contentToString()}")
    println("Transformed Data: ${transformedData.contentToString()}")
}

// bIRCH (Balanced Iterative Reducing and Clustering using Hierarchies) Algorithm is a hierarchical clustering algorithm that builds a tree-like structure to represent clusters.
// It efficiently handles large datasets by incrementally updating the structure as new data points arrive.

// Imagine you have a massive dataset of customer transactions in an e-commerce platform.
// BIRCH can be applied to group customers based on their purchasing behavior, enabling targeted marketing strategies.

// The folllowing dependency is to be added to the build.gradle file:
// implementation 'org.apache.commons:commons-math3:3.6.1'

class BIRCHExample(private val dataset: List<DoubleArray>, private val threshold: Double) {
    fun performBIRCH(): List<Cluster<DoublePoint>> {
        val birchClusterer: Clusterer<DoublePoint> = BirchClusterer(threshold, EuclideanDistance())
        return birchClusterer.cluster(dataset.map(::DoublePoint))
    }
}

fun main() {
    val dataset = listOf(
        doubleArrayOf(1.0, 2.0),
        doubleArrayOf(1.5, 1.8),
        doubleArrayOf(5.0, 8.0),
        // Add more data points as needed
    )

    val threshold = 1.0

    val birchExample = BIRCExample(dataset, threshold)
    val clusters = birchExample.performBIRCH()

    println("Number of Clusters: ${clusters.size}")
    clusters.forEachIndexed { index, cluster ->
        println("Cluster $index")
        cluster.points.forEach { point ->
            println(point.point)
        }
    }
}

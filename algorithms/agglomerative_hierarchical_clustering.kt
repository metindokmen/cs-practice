// Agglomerative Hierarchical Clustering starts with each data point as a separate cluster and merges the closest clusters iteratively until only one cluster remains.
// The result is a dendrogram representing the hierarchy of clusters.

// Imagine you have a dataset of customer purchase histories.
// Agglomerative Hierarchical Clustering can be applied to group similar customers into clusters based on their buying patterns, creating a hierarchy of customer segments.

// The following dependency is to be added to the build.gradle file:
// implementation 'org.apache.commons:commons-math3:3.6.1'

import org.apache.commons.math3.ml.clustering.Cluster
import org.apache.commons.math3.ml.clustering.Clusterer
import org.apache.commons.math3.ml.clustering.DoublePoint
import org.apache.commons.math3.ml.clustering.HierarchicalClusterer

class AgglomerativeHierarchicalClusteringExample(private val dataset: List<DoubleArray>, private val linkage: String) {
    fun performAgglomerativeHierarchicalClustering(): Cluster<DoublePoint> {
        val hierarchicalClusterer: Clusterer<DoublePoint> = HierarchicalClusterer(linkage)
        return hierarchicalClusterer.cluster(dataset.map(::DoublePoint))
    }
}

fun main() {
    val dataset = listOf(
        doubleArrayOf(1.0, 2.0),
        doubleArrayOf(1.5, 1.8),
        doubleArrayOf(5.0, 8.0),
        // Add more data points as needed
    )

    val linkage = "single" // You can choose "single", "complete", or "average" linkage

    val agglomerativeHierarchicalClusteringExample =
        AgglomerativeHierarchicalClusteringExample(dataset, linkage)
    val cluster = agglomerativeHierarchicalClusteringExample.performAgglomerativeHierarchicalClustering()

    println("Number of Clusters: ${cluster.size}")
    cluster.points.forEachIndexed { index, point ->
        println("Cluster $index: ${point.point}")
    }
}

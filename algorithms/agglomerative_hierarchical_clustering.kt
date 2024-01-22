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

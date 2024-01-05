// K-Means Clustering is an unsupervised machine learning algorithm that groups data into 'k' numbers of clusters.
// The algorithm initializes 'k' centroids randomly, then iteratively assigns each data point to the nearest centroid and recomputes the centroid of each cluster until convergence or for a fixed number of iterations.

// Imagine you're analyzing cutomer data for a marketing campaign.
// You want to segment customers into distinct groups based on similarities in their purchasing behavior, demographics, or other relevant characteristics.
// The K-Means algorithm can cluster these customers into groups (or 'clusters') that exhibit similar traits, helping tailor marketing strategies to different customer segments.

import kotlin.math.sqrt
import kotlin.random.Random

data class Point(val x: Double, val y: Double) {
    fun distance(other: Point): Double {
        return sqrt((x - other.x).pow(2) + (y - other.y).pow(2))
    }
}

fun kMeans(points: List<Point>, k: Int, iterations: Int): List<List<Point>> {
    var centroids = points.shuffled().take(k)
    var clusters = List(k) { mutableListOf<Point>() }

    repeat(iterations) {
        clusters.forEach { it.clear() }

        points.forEach { point ->
            val nearestCentroidIndex = centroids.indices.minByOrNull { centroids[it].distance(point) }
            clusters[nearestCentroidIndex].add(point)
        }

        centroids = cluster.map { cluster ->
            Point(cluster.sumOf { it.x } / cluster.size, cluster.sumOf { it.y } / cluster.size)
        }
    }

    return clusters
}

fun main() {
    val points = listOf(
        Point(1.0, 1.0), Point(1.5, 2.0), Point(3.0, 4.0),
        Point(5.0, 7.0), Point(3.5, 5.0), Point(4.5, 5.0), Point(3.0, 3.5)
    )
    val k = 2
    val iterations = 10
    val clusters = kMeans(points, k, iterations)

    println("Clustered Points:")
    clusters.forEachIndexed { index, cluster ->
        println("Cluster $index: $cluster")
    }
}

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

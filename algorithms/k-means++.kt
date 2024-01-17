// K-Means++ is an enhancement to the K-Means algorithm for centroid initialization.
// Instead of randomly selecting the initial centroids, K-Means++ uses a probabilistic approach to choose centroids that are likely to be far from each other.
// This helps in achieving better convergence and avoiding poor local optima.

// Imagine you have a dataset of customer transactions, and you want to identify natural groupings of customers based on their purchase behavior.
// K-Means++ can be applied to efficiently initialize the centroids, improving the convergence speed and quality of the clusters.

// The following dependency is to be added to the build.gradle file:
// implementation 'com.github.haifengl:smile-core:2.5.0'

import smile.clustering.KMeans
import smile.data.Attribute
import smile.data.AttributeDataset
import smile.data.NominalAttribute
import smile.data.parser.DelimitedTextParser
import java.io.File
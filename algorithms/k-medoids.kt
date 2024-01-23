// K-Medoids is an extension of K-Means that uses actual data points as medoids (cluster representatives).
// It minimizes the sum of dissimilarities (e.g. distance or dissimilarity measure) between data points and their respective medoids.

// Consider a delivery service managing a fleet of vehicles.
// K-Medoids can be applied to cluster vehicle locations, selecting the most centrally located vehicle within each cluster as a representative,
// facilitating efficient route planning.

// The following dependency is to be added to the build.gradle file:
// implementation 'com.github.haifengl:smile-core:2.5.0'

import smile.clustering.KMedoids
import smile.data.Attribute
import smile.data.AttributeDataset
import smile.data.NominalAttribute
import smile.data.parser.DelimitedTextParser
import java.io.File

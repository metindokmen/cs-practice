// DBSCAN (Density-Based Spatial Clustering of Applications with Noise) Algorithm groups together data points that are close to each other
// and have a sufficient number of neighboring points, forming dense regions.
// It classifies points as core, border, or noise based on their density.

// Consider a geographical dataset of mobile users, and you want to identify clusters of users who frequently visit certain locations.
// DBSCAN can help identify dense regions representing significant user activity.

// The following dependency is to be added to the build.gradle file:
// implementation 'com.github.haifengl:smile-core:2.5.0'

import smile.clustering.DBSCAN
import smile.data.Attribute
import smile.data.AttributeDataset
import smile.data.NominalAttribute
import smile.data.parser.DelimitedTextParser
import java.io.File

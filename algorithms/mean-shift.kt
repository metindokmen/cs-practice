// Mean-Shift is a mode-seeking algorithm that seeks modes or peaks in the data density.
// It iteratively shifts each data point toward the mean of the data points within a local neighborhood until convergence.
// The resulting clusters are centered around high-density regions.

// Imagine you have a dataset representing customer locations, and you want to identify clusters of high-density regions to target specific marketing strategies.
// Mean-Shift can be applied to discover these clusters based on the density of data points.

// The following dependency is to be added to the build.gradle file:
// implementation 'com.github.haifengl:smile-core:2.5.0'

import smile.clustering.MeanShift
import smile.data.Attribute
import smile.data.AttributeDataset
import smile.data.NominalAttribute
import smile.data.parser.DelimitedTextParser
import java.io.File

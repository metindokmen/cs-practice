// HAC starts with each data point as a separate cluster and iteratively merges the closest clusters until only one cluster remains.
// The result is a tree-like structure called a dendrogram, representing the hierarchy of cluster relationships.

// Imagine you have a dataset of customer purchase histories, and you want to identify groups of products that are frequently bought together.
// HAC can be applied to create a hierarchy of product clusters, capturing relationships at different levels of granularity.

// The following dependency is to be added to the build.gradle file:
// implementation 'com.github.haifengl:smile-core:2.5.0'

import smile.clustering.HierarchicalClustering
import smile.data.Attribute
import smile.data.AttributeDataset
import smile.data.NominalAttribute
import smile.data.parser.DelimitedTextParser
import java.io.File


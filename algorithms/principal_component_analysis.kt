// PCA aims to transform the original features into a new set of uncorrelated features, known as principal components.
// These components are ordered by the amount of varianca they capture in the data, allowing you to retain the most relevant information with fewer features.

// Imagine you have a dataset with numerous features, and you want to reduce its dimensionality while retaining as much relevant information as possible.
// PCA can be applied to identify the principal components, which are new features that capture the most significant variations in the data.
// This can be beneficial in various applications, such as image compression, facial recognition, and signal processing.

// The following dependency is to be added to the build.gradle file:
// implementation 'com.github.haifeng1:smile-core:2.5.0'

import smile.projection.PCA

data class DataPoint(val feature1: Double, val feature2: Double, val feature3: Double)

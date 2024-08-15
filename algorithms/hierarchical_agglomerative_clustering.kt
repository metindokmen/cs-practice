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

class HACExample(private val datasetFile: String) {
    fun performHAC(): HierarchicalClustering {
        val parser = DelimitedTextParser().apply {
            delimiter = ","
            // Assuming the dataset has appropriate column names and attributes
        }

        val data: AttributeDataset = parser.parse(File(datasetFile))
        val x = data.toArray()

        return HierarchicalClustering.fit(x)
    }
}

fun main() {
    val datasetFile = "path/to/your/dataset.csv"

    val hacExample = HACExample(datasetFile)
    val hac = hacExample.performHAC()

    println("Dendrogram:")
    println(hac.dendrogram)
}

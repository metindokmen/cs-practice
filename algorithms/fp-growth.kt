// FP-Growth (Frequent Pattern growth) is an algorithm for mining frequent itemsets without generating candidate sets explicitly.
// It uses a data structure called an FP-tree (Frequent Pattern tree) to efficiently mine frequent itemsets.

// Consider a retail business analyzing customer purchase data.
// The FP-growth algorithm can identify frequent itemsets, helping the business understand which products are often purchased together.

// The following dependencies are to be added to the build.gradle file:
// implementation 'org.apache.commons:commons-math3:3.6.1'
// implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2'
// implementation 'com.github.haifengl:smile-core:2.5.0'

import org.apache.commons.math3.ml.clustering.FPGrowth
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.toList

class FPGrowthExample(private val transactions: List<List<String>>, private val minSupport: Double) {
    suspend fun performFPGrowth(): List<List<String>> {
        val fpGrowth = FPGrowth(minSupport)

        val itemsets = fpGrowth.learn(transactions.asFlow().toList())
        return itemsets.map { it.map { item -> item.toString() } }
    }
}

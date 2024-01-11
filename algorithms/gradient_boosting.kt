// Gradient Boosting builds an additive model by training weak learners (usually decision trees) sequentially.
// Each tree is trained to correct the errors of the combined ensemble.
// The algorithm minimizes a loss function, and each tree is added to the ensemble with a weight that is determined by the optimization process.

// Imagine you are working on a project to predict housing prices.
// Gradient Boosting can be applied to build an ensemble of decision trees, where each tree corrects the errors of the previous ones.
// This leads to a robust model capable of capturing complex relationships in the data and making accurate predictions.

// The following dependency is to be added to the build.gradle file:
// implementation 'com.github.haifengl:smile-core:2.5.0'

import smile.regression.GBM
import smile.validation.RMSE

data class House(val size: Double, val bedrooms: Int, val price: Double)

class GradientBoostingExample(private val trainingData: List<House>) {
    fun trainModel(): GBM {
        val x = trainingData.map { doubleArrayOf(it.size, it.bedrooms.toDouble()) }.toTypedArray()
        val y = trainingData.map { it.price }.toDoubleArray()

        return GBM.fit(x, y, 100) // 100 trees in the ensemble
    }

    fun predict(model: GBM, newHouse: House): Double {
        val x = doubleArrayOf(newHouse.size, newHouse.bedrooms.toDouble())
        return model.predict(x)
    }
}

// Gradient Descent is a first-order iterative optimization algorithm used to find the minimum of a function.
// Specifically, in machine learning, it's used to minimize a loss function by iteratively moving towards the steepest descent as defined by the negative of the gradient.
// It's fundamental in training many types of machine learning models.

// Imagine you are developing a machine learning model to predict housing prices based on features like size, location, and number of bedrooms.
// The challenge is to find the best model parameters (weights) that minimze the prediction error.
// Gradient Descent is an iterative optimization algorithm used to find the minimum of a function (in this case, the loss function that measures prediction errors).

class LinearRegression(val learningRate: Double, val iterations: Int) {
    var weights: DoubleArray = doubleArrayOf()

    fun fit(X: Array<DoubleArray>, y: DoubleArray) {
        val nFeatures = X[0].size
        weights = DoubleArray(nFeatures) { 0.0 }

        for (i in 0 until iterations) {
            val gradients = DoubleArray(nFeatures) { 0.0 }
            for (j in X.indices) {
                val prediction = predict(X[j])
                for (k in gradients.indices) {
                    gradients[k] += (prediction - y[j]) * X[j][k]
                }
            }
            for (k in weights.indices) {
                weights[k] -= learningRate * gradients[k] / X.size
            }
        }
    }

    fun predict(x: DoubleArray): Double {
        return weights.zip(x).sumOf { (weight, feature) -> weight * feature }
    }
}

fun main() {
    val X = arrayOf(doubleArrayOf(1.0, 50.0), doubleArrayOf(1.0, 60.0), doubleArrayOf(1.0, 70.0))
    val y = doubleArrayOf(150000.0, 180000.0, 210000.0)

    val model = LinearRegression(learningRate = 0.0001, iterations = 10000)
    model.fit(X, y)

    val prediction = model.predict(doubleArrayOf(1.0, 65.0)) // Predicting for 65 square meters
    println("Predicted price: $prediction")
}

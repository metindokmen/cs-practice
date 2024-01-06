// The Naive bayes classifier is a probabilistic machine learning model based on Bayes' Theorem with the "naive" assumption of conditional independence between every pair of features given the value of the class variable.
// Despite its simplicity, Naive Bayes can outperform more complex models, especially in text classification.

// Imagine you're developing a spam filter for an email application.
// You need a way to classify incoming emails into "spam" or "not spam" based on their content.
// The Naive Bayes Classifier is ideal for this task.
// It uses the probabilities of words appearing in spam and non-spam emails to calculate the likelihood of a new email being in one of these categories.

class NaiveBayesClassifier {
    private val logLikelihoods = mutableMapOf<String, MutableMap<String, Double>>()
    private val logClassPriors = mutableMapOf<String, Double>()

    fun train(data: List<Pair<String, List<String>>>) {
        val classFrequencies = mutableMapOf<String, Int>()
        val featureFrequencies = mutableMapOf<String, MutableMap<String, Int>>()

        data.forEach { (category, features) ->
            logClassPriors[category] = logClassPriors.getOrDefault(category, 0.0) + 1
            classFrequencies[category] = classFrequencies.getOrDefault(category, 0) + 1
            features.forEach { feature ->
                featureFrequencies.getOrPut(feature) { mutableMapOf() }[category] = featureFrequencies.getOrPut(feature) { mutableMapOf() }.getOrDefault(category, 0) + 1
            }
        }

        val numDataPoints = data.size.toDouble()
        logClassPriors.forEach { (category, count) ->
            logClassPriors[category] = kotlin.math.log(count / numDataPoints)
        }

        featureFrequencies.forEach { (feature, categoryCounts) ->
            val logProbabilities = mutableMapOf<String, Double>()
            categoryCounts.forEach { (category, count) ->
                val logProbability = kotlin.math.log(count.toDouble() / classFrequencies[category]!!)
                logProbabilities[category] = logProbability
            }
            logLikelihoods[feature] = logProbabilities
        }
    }

}
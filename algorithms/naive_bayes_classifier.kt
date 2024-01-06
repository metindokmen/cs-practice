// The Naive bayes classifier is a probabilistic machine learning model based on Bayes' Theorem with the "naive" assumption of conditional independence between every pair of features given the value of the class variable.
// Despite its simplicity, Naive Bayes can outperform more complex models, especially in text classification.

// Imagine you're developing a spam filter for an email application.
// You need a way to classify incoming emails into "spam" or "not spam" based on their content.
// The Naive Bayes Classifier is ideal for this task.
// It uses the probabilities of words appearing in spam and non-spam emails to calculate the likelihood of a new email being in one of these categories.

class NaiveBayesClassifier {
    private val logLikelihoods = mutableMapOf<String, MutableMap<String, Double>>()
    private val logClassPriors = mutableMapOf<String, Double>()


}
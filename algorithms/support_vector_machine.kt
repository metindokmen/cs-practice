// SVM is a supervised learning algorithm that finds the hyperplane in an N-dimensional space (N is the number of features) that distinctly classifies the data points.
// It works by maximizing the margin between different classes and can handle both linear and non-linear classification tasks through the use of different kernel functions.

// Imagine you're working on a project to classify emails as spam or not spam.
// The SVM algorithm can be applied to create a decision boundary that effectively separates spam and non-spam emails
// in a high-dimensional space based on features such as the frequency of certain words or patterns.
// SVM is widely used in text and image classification tasks.

// The following dependency should be added to the build.gradle file of the project:
// implementation 'com.github.austinv11:SVM:1.4.0'

import com.austinv11.ssvm.SSVM
import com.austinv11.ssvm.libsvm.svm_node
import com.austinv11.ssvm.libsvm.svm_problem

data class Email(val wordFrequency1: Double, val wordFrequency2: Double, val label: Int)

class SVMClassifier(private val trainingData: List<Email>) {
    private val svmProblem = svm_problem()

    init {
        val labels = trainingData.map { it.label.toDouble() }.toDoubleArray()
        val nodes = trainingData.map { email ->
            val node1 = svm_node()
            node1.index = 1
            node1.value = email.wordFrequency1

            val node2 = svm_node()
            node2.index = 2
            node2.value = email.wordFrequency2

            arrayOf(node1, node2)
        }.toTypedArray()

        svmProblem.y = labels
        svmProblem.x = nodes
        svmProblem.l = trainingData.size
    }

    fun train() {
        val svm = SSVM()
        svm.svmTrain(svmProblem, null, null)
    }

    fun predict(newEmail: Email): Int {
        val node1 = svm_node()
        node1.index = 1
        node1.value = newEmail.wordFrequency1

        val node2 = svm_node()
        node2.index = 2
        node2.value = newEmail.wordFrequency2

        val newNode = arrayOf(node1, node2)
        return SSVM.predict(newNode, svmProblem, null)
    }
}

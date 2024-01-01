// A Decision Tree is a flowchart-like tree structure where an internal node represents a feature (or attribute),
// the branch represents a decision rule, and each leaf node represents the outcome.
// The topmost node in a decision tree is known as the root node.
// The algorithm splits the data into subsets based on the value of the input features,
// and this process is repeated recursively, resulting in a tree-lioke model of decisions.

// Imagine you are developing a system to predict whether a customer will buy a particular product based on various attributes like age, income, browsing history, and so on.
// A decision tree can help by creating a model that makes predictions based on the decision rules inferred from the data.

data class TreeNode<T>(
    val featureName: String?,
    val value: T?,
    val branches: Map<T, TreeNode<T>?> = mapOf()
)

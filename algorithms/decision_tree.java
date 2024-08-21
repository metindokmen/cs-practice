// A Decision Tree is a supervised machine learning algorithm used for classification and regression tasks.
// It mimics human decision-making by splitting data into branches based on feature values, leading to decisions represented by leaf nodes.

// The tree structure consists of:
// - Root node: Represents the entire dataset.
// - Internal Nodes: Represent features that split data.
// - Branches: Represent outcomes of feature tests.
// - Leaf Nodes: Represent decisions or outcomes.

// Imagine you want to decide whether to play tennis based on weather conditions. The features are:
// - Outlook (Sunny, Overcast, Rainy)
// - Tempreature (Hot, Mild, Cool)
// - Humidity (High, Normal)
// - Wind (Strong, Weak)

// The decision tree can help you decide whether to play tennis by evaluating features.


// Represents each node in the tree
class Node {
    String question;
    Node yesBranch;
    Node noBranch;

    public Node(String question) {
        this.question = question;
    }
}

public class DecisionTree {
    Node root;

    public DecisionTree() {
        root = new Node("Is it Sunny?");
        root.yesBranch = new Node("Is the humidity high?");
        root.noBranch = new Node("Is it overcast?");

        root.yesBranch.yesBranch = new Node("No, don't play tennis.");
        root.yesBranch.noBranch = new Node("Yes, play tennis.");

        root.noBranch.yesBranch = new Node("Yes, play tennis.");
        root.noBranch.noBranch = new Node("Is it windy?");

        root.noBranch.noBranch.yesBranch = new Node("No, don't play tennis.");
        root.noBranch.noBranch.noBranch = new Node("Yes, play tennis.");
    }

    public String decide(String outlook, String humidity, String wind) {
        Node currentNode = root;

        if (outlook.equalsIgnoreCase("Sunny")) {
            currentNode = currentNode.yesBranch;
            if (humidity.equalsIgnoreCase("High")) {
                return currentNode.yesBranch.question;
            } else {
                return currentNode.noBranch.question;
            }
        } else if (outlook.equalsIgnoreCase("Overcast")) {
            return currentNode.noBranch.yesBranch.question;
        } else {
            currentNode = currentNode.noBranch.noBranch;
            if (wind.equalsIgnoreCase("Strong")) {
                return currentNode.yesBranch.question;
            } else {
                return currentNode.noBranch.question;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DecisionTree = new DecisionTree();

        // Sample inputs
        String outlook = "Sunny";
        String humidity = "High";
        String wind = "Weak";

        // Decision based on inputs
        String decision = tree.decide(outlook, humidity, wind);
        System.out.println("Decision: " + decision);
    }
}

// A Binary Search Tree is a binary tree data structure where each node has at most two children (left and right), and for each node:
// - The left child's key is less than the node's key.
// - The right child's key is greater than the node's key.
// This property enables efficient search, insert, and delete operations.

// Think of a phonebook where entires are stored alphabetically by last name.
// Each entry (node) contains a last name (key) and associated information (value).
// Searching for a specific last name efficiently is analogous to using a BST.

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    public boolean searchRec(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.key == key) {
            return true;
        } else if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        System.out.println("Search for 30: " + bst.search(30));
        System.out.println("Search for 60: " + bst.search(60));
    }
}

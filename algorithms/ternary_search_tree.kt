// A Ternary Search Tree is a special type of trie data structure where each node has three children:
// one for characters less than the current node's character,
// one for characters equal to the current node's character,
// and one for characters greater than the current node's character.
// This structure allows for efficient storage and retrieval of strings.

// Imagine you have a dictionary of words, and you want to implement autocomplete functionality in a search engine or a text editor.
// A Ternary Search Tree can efficiently store and retrieve words, making it suitable for autocomplete functionality.

class TSTNode(var char: Char) {
    var isEndOfWord = false
    var left: TSTNode? = null
    var middle: TSTNode? = null
    var right: TSTNode? = null
}

class TernarySearchTree {
    private var root: TSTNode? = null

    fun insert(word: String) {
        root = insert(root, word, 0)
    }

    private fun insert(node: TSTNode?, word: String, index: Int): TSTNode? {
        var currentNode = node
        if (currentNode == null) {
            currentNode = TSTNode(word[index])
        }

        val char = word[index]
        when {
            char < currentNode.char -> currentNode.left = insert(currentNode.left, word, index)
            char > currentNode.char -> currentNode.right = insert(currentNode.right, word, index)
            index < word.length - 1 -> currentNode.middle = insert(currentNode.middle, word, index + 1)
            else -> currentNode.isEndOfWord = true
        }
        return currentNode
    }

    fun search(word: String): Boolean {
        return search(root, word, 0)
    }

    private fun search(node: TSTNode?, word: String, index: Int): Boolean {
        if (node == null) return false

        val char = word[index]
        return when {
            char < node.char -> search(node.left, word, index)
            char > node.char -> search(node.right, word, index)
            index < word.length - 1 -> search(node.middle, word, index + 1)
            else -> node.isEndOfWord
        }
    }
}

fun main() {
    val tst = TernarySearchTree()
    tst.insert("apple")
    tst.insert("banana")
    tst.insert("orange")
    tst.insert("pear")

    println(tst.search("apple")) // Expected Output: true
    println(tst.search("banana")) // Expected Output: true
    println(tst.search("grape")) // Expected Output: false
    println(tst.search("pear")) // Expected Output: true
}

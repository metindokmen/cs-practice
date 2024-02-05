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

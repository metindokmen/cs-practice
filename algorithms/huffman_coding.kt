// Huffman Coding is a widely used method of lossless data compression.
// It assigns variable=length codes to input characters, with shorter codes assigned to more frequent characters.
// This is achieved by building a binary tree (Huffman Tree), where each leaf node represents a character,
// and the path from the root to the leaf gives the character's binary code.

// Imagine you're developing a file compression tool.
// You need to encode text in a way that reduces its size for storage or transmission.
// Huffman Coding provides an efficient way of encoding characters based on their frequency in the text.
// Characters that occur more frequently are encoded with shorter codes, and less frequent characters with longer codes, reducing the overall size of the text.

import java.util.PriorityQueue

class HuffmanNode(var char: Char, var frequency: Int) : Comparable<HuffmanNode> {
    var left: HuffmanNode? = null
    var right: HuffmanNode? = null

    override fun compareTo(other: HuffmanNode): Int = this.frequency - other.frequency
}

fun buildTree(frequencies: Map<Char, Int>): HuffmanNode {
    val priorityQueue = PriorityQueue<HuffmanNode>()

    frequencies.forEach { (char, freq) ->
        priorityQueue.add(HuffmanNode(char, freq))
    }

    while (priorityQueue.size > 1) {
        val left = priorityQueue.poll()
        val right = priorityQueue.poll()
        val sum = left.frequency + right.frequency
        val node = HuffmanNode("-", sum)
        node.left = left
        node.right = right
        priorityQueue.add(node)
    }

    return priorityQueue.poll()
}

fun printCodes(node: HuffmanNode, prefix: String = "") {
    if (node.left == null && node.right == null) {
        println("${node.char}: $prefix")
        return
    }
    printCodes(node.left!!, prefix + "0")
    printCodes(node.right!!, prefix + "1")
}

// Huffman Coding is a widely used method of lossless data compression.
// It assigns variable=length codes to input characters, with shorter codes assigned to more frequent characters.
// This is achieved by building a binary tree (Huffman Tree), where each leaf node represents a character,
// and the path from the root to the leaf gives the character's binary code.

// Imagine you're developing a file compression tool.
// You need to encode text in a way that reduces its size for storage or transmission.
// Huffman Coding provides an efficient way of encoding characters based on their frequency in the text.
// Characters that occur more frequently are encoded with shorter codes, and less frequent characters with longer codes, reducing the overall size of the text.

class HuffmanNode(var char: Char, var frequency: Int) : Comparable<HuffmanNode> {
    var left: HuffmanNode? = null
    var right: HuffmanNode? = null

    override fun compareTo(other: HuffmanNode): Int = this.frequency - other.frequency
}

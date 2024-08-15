// Given a set of characters and their frequencies, construct a binary tree where the path from the root to each character is the code for that character.
// The goal is to minimize the total length of the encoded message.

// Imagine you are sending a large text file over a network where bandwidth is limited.
// You want to reduce the size of the file without losing any information.
// Huffman Coding helps by assigning shorter codes to more frequent characters, thus compressing the data efficiently.

import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        left = right = null;
    }

    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

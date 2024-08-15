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

public class HuffmanCoding {
    public static void main(String[] args) {
        String text = "hello huffman";
        huffmanEncode(text);
    }

    public static void huffmanEncode(String text) {
        // Step 1: Calculate frequency of each character
        int[] frequency = new int[256]; // Assuming ASCII characters
        for (char c : text.toCharArray()) {
            frequency[c]++;
        }

        // Step 2: Build the priority queue (min-heap)
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                minHeap.add(new HuffmanNode((char) i, frequency[i]));
            }
        }

        // Step 3: Build the Huffman Tree
        while (minHeap.size > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode internalNode = new HuffmanNode('-', left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;
            minHeap.add(internalNode);
        }

        // Step 4: Generate and print Huffman Codes
        HuffmanNode root = minHeap.poll();
        printHuffmanCodes(root, "");
    }

    // Utility function to print Huffman Codes
    public static void printHuffmanCodes(HuffmanNode root, String code) {
        if (root == null) return;

        // If this is a leaf node, it contains one of the input characters
        if (root.left == null && root.right == null) {
            System.out.println(root.character + ": " + code);
        }

        // Recursively generate codes for left and right subtrees
        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }
}

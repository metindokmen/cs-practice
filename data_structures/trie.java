// A Trie is a tree-like data structure that stores a dynamic set of strings, where the keys are usually strings.
// It is used to store words in a way that facilitates fast prefix-based searches.
// Each node in a trie represents a single character, and each path down the tree represents a word.

// Imagine you are designing an autocomplete feature for a search engine.
// As a user types in the search box, you want to suggest possible completions based on the current prefix.
// A trie is an ideal data structure for this task because it allows you to quickly find all words that start with the given prefix.
// For example, if a user types "cat", the trie can quicky suggest "cat", "cater", "catapult" et cetera, based on the stored words.

// Use Cases
// 1. Autocomplete Systems: Suggesting words based on prefixes.
// 2. Spell checkers: Validating if a string is a valid word.
// 3. IP Routing: Longest prefix matching in networking.
// 4. Data compression: Strong dictionary words in a compact format.

// A trie is typically implemented with a root node that branches into child nodes, each representing a character.
// A node may have multiple children, corresponding to the next possible characters in the words.

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;

    public TrieNode() {}
}

public class Trie {
    private final TrieNode root;

    // Consturctor to intialize the Trie
    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord;
    }

    // Check if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("cater");
        trie.insert("car");
        trie.insert("cart");

        System.out.println(trie.search("cat")); // true
        System.out.println(trie.search("can")); // false
        System.out.println(trie.startsWith("car")); // true
        System.out.println(trie.startsWith("bat")); // false
    }
}

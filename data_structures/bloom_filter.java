// A Bloom Filter is a probabilistic data structure that is used to test whether an element is a member of a set.
// It can return false positives but never false negatives.
// This means it might indicate that an element is in the set even when it's not,
// but if it says the element is not in the set, you can be sure that it isn't.

// Imagine you are building an email system that needs to quickly check if an incoming email is spam.
// You maintain a large list of known spam emails and want to quickly check if the sender's email address is in that list.
// Using a Bloom Filter, you can quickly determine if the email address might be spam.
// If the Bloom Filter says "no", you can be certain it isn't spam; if it says "yes", you can further investigate or apply more intensive checks.

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

class BloomFilter {
    private BitSet bitSet;
    private int bitSetSize;
    private int[] hashSeeds;
    private Set<String> actualSet; // To track actual elements (not part of the actual bloom filter but for demo)

    public BloomFilter(int bitSetSize, int HashFunctionCount) {
        this.bitSetSize = bitSetSize;
        this.bitSet = new BitSet(bitSetSize);
        this.hashSeeds = new int[hashFunctionCount];
        this.actualSet = new HashSet<>();

        for (int i = 0; i < hashFunctionCount; i++) {
            hashSeeds[i] = i + 1; // Simple hash seeds, in practice use better hash functions
        }
    }

    // Add element to the Bloom Filter
    public void add(String element) {}

    // Check if an element might be in the Bloom Filter
    public boolean mightContain(String element) {}

    // Simple hash function for demonstration purposes
    private int getHash(String element, int seed) {}

    // For demonstration: Check if the element is actually in the set
    public boolean isInActualSet(String element) {}


}
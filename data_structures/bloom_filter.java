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
    public void add(String element) {
        actualSet.add(element); // Track the element in a set (for demo purposes)
        for (int seed : hashSeeds) {
            for (int seed : hashSeeds) {
                int hash = getHash(element, seed);
                bitSet.set(Math.abs(hash % bitSetSize), true);
            }
        }
    }

    // Check if an element might be in the Bloom Filter
    public boolean mightContain(String element) {
        for (int seed : hashSeeds) {
            int hash = getHash(element, seed);
            if (!bitSet.get(Math.abs(hash % bitSetSize))) {
                return false;
            }
        }
        return true;
    }

    // Simple hash function for demonstration purposes
    private int getHash(String element, int seed) {
        int hash = 0;
        for (char c : element.toCharArray()) {
            hash = seed * hash + c;
        }
        return hash;
    }

    // For demonstration: Check if the element is actually in the set
    public boolean isInActualSet(String element) {
        return actualSet.contains(element);
    }

}

public class Main {
    public static void main(String[] args) {
        // Create a Bloom Filter with a bitset size of 1000 and 3 hash functions
        BloomFilter bloomFilter = new BloomFilter(1000, 3);

        // Add some known spam email addresses
        BloomFilter.add("spam@example.com");
        BloomFilter.add("junk@mail.com");
        BloomFilter.add("fake@news.com");

        // Test some email addresses
        String email1 = "spam@example.com";
        String email2 = "notspam@example.com";
        String email3 = "fake@news.com";
        String email4 = "unknown@mail.com";

        System.out.println(email1 + " might be spam: " + bloomFilter.mightContain(email1)); // Expected: true
        System.out.println(email2 + " might be spam: " + bloomFilter.mightContain(email2)); // Expected: false
        System.out.println(email3 + " might be spam: " + bloomFilter.mightContain(email3)); // Expected: true
        System.out.println(email4 + " might be spam: " + bloomFilter.mightContain(email4)); // Expected: false

        // For demo purposes, checking against the actual set (not part of bloom filter)
        System.out.println(email1 + " is actually spam: " + bloomFilter.isInActualSet(email1)); // Expected: true
        System.out.println(email2 + " is actually spam: " + bloomFilter.isInActualSet(email2)); // Expected: false
        System.out.println(email3 + " is actually spam: " + bloomFilter.isInActualSet(email3)); // Expected: true
        System.out.println(email4 + " is actually spam: " + bloomFilter.isInActualSet(email4)); // Expected: false
    }
}

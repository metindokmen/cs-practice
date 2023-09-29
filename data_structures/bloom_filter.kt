// A bloom filter is a probabalistic data structure used to test whether an element is a member of a set.
// It allows for false positives - it might mistakenly say an item is in the set when it isn't.
// But it guarantees no false negatives - if it says an item isn't in the set, then it definitely isn't.

// Think of a spell checker that needs to quickly verify if a word exists in its dictionary.
// Given the vast number of words, storing them all would require significant memory.
// A Bloom Filter can efficiently represent this dictionary, allowing the spell checker to quickly ascertain if a word is likely in the dictionary or definitely not in it.

class BloomFilter(private val size: Int, private val hashFunction: List<(String) -> Int>) {
    private val bitset = BitSet(size)

    fun add(item: String) {
        for (hashFunc in hashFunctions) {
            val hash = hashFunc(item) % size
            bitset.set(hash)
        }
    }

    fun mightContain(item: String): Boolean {
        for (hashFunc in hashFunctions) {
            val hash = hashFunc(item) % size
            if (!bitset.get(hash)) return false
        }
        return true
    }
}

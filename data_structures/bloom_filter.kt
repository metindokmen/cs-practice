// A bloom filter is a probabalistic data structure used to test whether an element is a member of a set.
// It allows for false positives - it might mistakenly say an item is in the set when it isn't.
// But it guarantees no false negatives - if it says an item isn't in the set, then it definitely isn't.

// Think of a spell checker that needs to quickly verify if a word exists in its dictionary.
// Given the vast number of words, storing them all would require significant memory.
// A Bloom Filter can efficiently represent this dictionary, allowing the spell checker to quickly ascertain if a word is likely in the dictionary or definitely not in it.


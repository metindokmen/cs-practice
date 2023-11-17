// The Rabin-Karp algorithm is a string-searching algorithm that uses hashing to find any one of a set of pattern strings in a text.
// It works by calculating a hash value for the pattern and for each substring of the text of the same lenght as the pattern.
// If the hash values match, the algorithm then checks if the actual substring and the pattern are identical.
// This avoids the need for character-by-character comparisons in most cases.

// Imagine you're trying to find a particular word or phrase in a long document.
// Instead of comparing the search string to every substring of the document (which would be time-consuming),
// you calculate a hash of the search string and then look for matches of this hash within the document.
// This is the principle behind the Rabin-Karp algorithm.

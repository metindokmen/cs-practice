// KMP (Knuth-Morris-Pratt) Algorithm is an efficient string searching (or substring searching) algorithm that processes the pattern itself to determine how much of the comparison can be skipped.
// It pre-processes the pattern to create a `lps` (Longest Prefix which is also Suffix) array that helps in skipping characters while matching.

// Imagine you are reading a book and you want to find a particular word or phrase in it.
// Rather than reading every word from the start every time you want to find a match,
// you can use the KMP algorithm which efficiently skips portions of the text to improve the search.

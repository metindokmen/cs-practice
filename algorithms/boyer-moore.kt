// The boyer-Moore algorithm is an efficient string searching algorithm that skips sections of the text to be searched.
// It preprocesses the pattern to create two different heuristics - the bad character heuristic and the good suffix heuristic.
// These heuristics allow the algorithm to skip over positions of the text where the pattern cannot possible match, leading to fewer comparisons than simpler algorithms,
// especially when the pattern length is long.

// Imagine you're going through a large book looking for a specific word or phrase.
// Instead of reading every word from start to finish, you might skip ahead multiple characters at a time, especially if you know the word you're looking for is quite distinct.
// The Boyer-Moore algorithm uses a similar idea to efficiently find a substring in a larger string by skipping sections of the text that cannot possibly contain the search string.

// The boyer-Moore algorithm is an efficient string searching algorithm that skips sections of the text to be searched.
// It preprocesses the pattern to create two different heuristics - the bad character heuristic and the good suffix heuristic.
// These heuristics allow the algorithm to skip over positions of the text where the pattern cannot possible match, leading to fewer comparisons than simpler algorithms,
// especially when the pattern length is long.

// The Fisher-Yates Shuffle algorithm, also known as the Knuth Shuffle, works by iteratively selecting a random element from the remaining unshuffled elements, and swapping it with the current element.
// This process ensures that every element is equally likely to end up in any position of the shuffled array.

// Steps:
// 1. Start from the last element of the array.
// 2. Randomly select an index from the unshuffled portion of the array (from 0 to the current index).
// 3. Swap the selected element with the current element.
// 4. Decrement the index and repeat until the first element is reached.

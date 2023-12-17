// Bucket Sort is an efficient sorting algorithm for sorting elements that are uniformly distributed across a range.
// It works by distributing elements into several "buckets" and then sorting these buckets individually.
// Each bucket is sorted individually using a different sorting algorithm, typically insertion sort, due to its efficiency with small data sets.

// Imagine you're a teacher with a large stack of exams scored between 0 and 100, and you need to sort them.
// Instead of comparing each exam with others (like in bubble sort or quicksort), you can create 10 buckets, each representing a range of 10 scores.
// You then distribute the exams into these buckets based on their scores.
// Finally, you sort the exams within each bucket and then combine them back.
// This method can be much faster for such a specific case, especially with a large number of exams.
// This is essentially what Bucket Sort does.

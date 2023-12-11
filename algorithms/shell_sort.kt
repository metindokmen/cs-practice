// Shell Sort is a generalization of insertion sort that allows the exchange of items that are far apart.
// The idea is to arrange the list of elements so that, starting anywhere, taking every hth element produces a sorted list.
// Such a list is said to be h-sorted. It start by sorting pairs of elements far apart from each other, then progressively reducing the gap between elements to be compared.

// Imagine you're organizing a large set of library books by their ID numbers.
// Instead of comparing each book only with its immediate neighbor (as in insertion sort), you start by comparing books that are farther apart
// and gradually reduce this gap. This method can quickly bring books that are far out of place closer to their correct position, thus speeding up the sorting process.
// This is eseentially what the Shell Sort algorithm does.

// A Skip List is a data structure for storing a sorted collection of items with a hierarchy of linked lists that skip over varying numbers of elements.
// It allows for fast search, insertion, and deletion operations.
// Skip Lists are an alternative to balanced trees and are easier to implement while providing similar efficiency.

// Think of an express train service between cities. There are local trains that stop at every city, and then there are express trains that skip many cities and only stop at major hubs.
// If you're travelling a long distance, you might take an express train and then switch to a local train at the last hub.
// This is how a Skip List works. The "express" linked lists allow us to skip over many elements, and the "local" linked lists provide fine-grained traversal.
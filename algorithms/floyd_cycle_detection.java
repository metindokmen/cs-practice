// Floyd's Cycle Detection Algorithm is used to detect cycles in linked lists.
// It's particularly useful in scenarios where you want to identify whether a linked list contains a cycle (i.e., a loop where a node points back to a previously visited node).

// Floyd's Cycle Detection Algorithm uses two pointers, referred to as slow and fast pointers, to detect cycles in a linked list.
// The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
// If there's a cycle in the linked list, the fast pointer will eventually meet the slow pointer inside the cycle.

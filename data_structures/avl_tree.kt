// AVL Tree Data Structure

// 1. Structure: An AVL tree is a binary search tree where the height difference between the left and the right subtrees of any node (known as the balance factor) is at most 1.

// 2. Properties:
// - Each node stores a key-value pair.
// - For any node, the key of the left child is less than the node's key, and the key of the right child is greater.
// - The balance factor of any node is calculated as the height of its right subtree minus the height of its left subtree.
// - AVL trees automatically balance themselves during insertion and deletion operations to maintain the AVL property.

// 3. Operations
// - Search: Begins at the root and recursively searches for the key in the left or right subtree based on comparison with the current node's key.
// - Insertion: Performs a standard binary search tree insertion and then rebalances the tree by performing rotations to maintain the AVL property.
// - Deletion: Similar to insertion, deletes the node and then realances the tree using rotations if necessary.
// - Rotation: AVL trees use rotations (single or double) to balance the three after insertion or deletion.

// 4. Advantages:
// - Ensures that the tree remains balanced, resulting in efficient search, insertion, and eletion operations.
// - Guarantees worst-case time complexity of O(log n) for all operations.

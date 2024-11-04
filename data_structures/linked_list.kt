// A linked list is a linear data structure that stores data in nodes, which are connected by pointers.
// Unlike arrays, linked lists are not stored in contiguous memory locations.

// Characteristics of Linked List:
// - Dynamic: Linked Lists can be easily resized by adding or removing nodes.
// - Non-contiguous: Nodes are stored in random memory locations and connected by pointers.
// - Sequential access: Nodes can only be accessed sequentially, starting from the head of the list.

// Operations on Linked List:
// - Creation: Creating a new linked list or adding a new node to an existing list.
// - Traversal: Iterating through the list and accessing each node.
// - Insertion: Adding a new node at a specific position in the list.
// - Deletion: Removing a node from the list.
// - Search: Finding a node with a specific value in the list.

// Types of Linked List:
// - Singly Linked List: Each node points to the next node in the list.
// - Doubly Linked List: Each node points to both the next and previous nodes in the list.
// - Circular Linked List: The last node points back to the first node, forming a circular loop.

// Applications of Linked List:
// - Implementing queues and stacks
// - Representing graphs and trees
// - Maintaining ordered data
// - Memory management

class Node<T>(var data: T) {
    var next: Node<T>? = null
}

class LinkedList<T> {
    private var head: Node<T>? = null

    fun insertAtBeginning(data: T) {
        val newNode = Node(data)
        newNode.next = head
        head = newNode
    }

    fun insertAtEnd(data: T) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    // @TODO: traverse
    // @TODO: delete
    // @TODO: search
}
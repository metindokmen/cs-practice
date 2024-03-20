// Floyd's Tortoise and Hare algorithm, also known as cycle detection algorithm,
// is used to detect cycles in a linked list efficiently without using any additional data structure.

// Suppose you have a circular race track where racers run around the track.
// Some racers might be faster than others, and eventually, they may meet or overlap if the track is circular.
// The Floyd's Tortoise and Hare algorithm can be used to detect if any two racers ever meet on the track.

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun hashCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while (fast?.next != null && fast.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            return true // Cycle detected
        }
        return false // No cycle found
    }
}

fun main() {
    // Create a linked list with a cycle
    val head = ListNode(3)
    head.next = ListNode(2)
    head.next?.next = ListNode(0)
    head.next?.next?.next = ListNode(-4)
    head.next?.next?.next?.next = head.next // Create a cycle

    println("Linked list has a cycle ${hashCycle(head)}")
}

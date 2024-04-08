// Floyd's Cycle Detection Algorithm is used to detect cycles in linked lists.
// It's particularly useful in scenarios where you want to identify whether a linked list contains a cycle (i.e., a loop where a node points back to a previously visited node).

// Floyd's Cycle Detection Algorithm uses two pointers, referred to as slow and fast pointers, to detect cycles in a linked list.
// The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
// If there's a cycle in the linked list, the fast pointer will eventually meet the slow pointer inside the cycle.

// Imagine a scenario where you have a circular track and multiple runners are jogging on this track.
// Some runners might be faster than others.
// The challenge is to determine if any two runners will meet each other at some point on the track.

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class CycleDetection {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true; // Cycle detected
            }
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }

        return false; // No cycle found
    }

    public static void main(String[] args) {
        // Create a linked list with a cycle
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a cycle from -4 back to 2

        CycleDetection detector = new CycleDetection();
        boolean hasCycle = detector.hasCycle(head);

        System.out.println("Does the linked list have a cycle? " + hasCycle);
    }
}

// A set is a collection of distinct elements, where each element can exist only once.

// Suppose you want to organize a party and invite a list of friends.
// To insure you don't invite the same friend multiple times, you'd use a set to store their names.

fun main() {
    // Init the sets
    val friendsList1 = setOf("Alice", "Bob", "Charlie")
    val friendsList2 = setOf("Charlie", "David", "Eve")

    // Union: Combine two lists and remove duplicates
    val allInvited = friendsList1 union friendsList2
    println("All invited friends: $allInvited")

    val commonFriends = friendsList1 intersect friendsList2
    println("Common friends: $commonFriends")

    val exclusiveFriendsList1 = friendsList1 subtract friendsList2
    println("Friends only in the first list: $exclusiveFriendsList1")

    if ("Alice" in friendsList1) {
        println("Alice is in the first friends list")
    }

    // Use a mutable set to add or remove friends
    val mutableFriendsList = mutableSetOf("Fred", "George")
    mutableFriendsList.addAll("Harry")
    mutableFriendsList.removeAll("Fred")
    println("Mutable friends list: $mutableFriendsList")
}
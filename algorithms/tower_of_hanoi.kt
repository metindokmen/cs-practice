// The Tower of Hanoi algorithm is a recursive algorithm to solve the puzzle.
// The solution can be achieved by recursively moving a smallar stack of disks (n-1) to a buffer post,
// then moving the largest disk, and finally moving the smaller stack on top of the largest disk.

// Imagine you have three posts and a stack of different-sized disks that fit onto a post.
// The disks are stacked in ascending order of size on one post, with the smallest at the top.
// The task is to move the entire stack to another post, obeying the following rules:

// 1. Only one disk can be moved at a time.
// 2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack.
// 3. No disk may be placed on top of a smaller disk.

fun towerOfHanoi(n: Int, fromRod: String, toRod: String, auxRod: String) {
    if (n == 1) {
        println("Move disk 1 from rod $fromRod to rod $toRod")
        return
    }

    towerOfHanoi(n - 1, fromRod, auxRod, toRod)
    println("Move disk $n from rod $fromRod to rod $toRod")
    towerOfHanoi(n - 1, auxRod, toRod, fromRod)
}

fun main() {
    val numberOfDisks = 3
    towerOfHanoi(numberOfDisks, "A", "C", "B")
}

// Merge Sort is a divide-and-conquer algorithm that splits a list in half, recursively sorts the halves, and then merges them back together.
// The key insight is that a list of lenght 1 is always sorted, and merging two sorted lists is linear in the total number of elements.

// Imagine you have two stacks of playing cards, each sorted in ascending order.
// You want to merge them into a single stack, still sorted in ascending order.
// To do this, you'd compare the cards at the top of the stacks, pick the smaller one, and place it on a new stack.
// You'd repeat this until one of your stacks is empty, then place the remaining cards from the other stack on top.
// This is the essence of the merge step in the Merge Sort algorithm.

fun mergeSort(list: MutableList<Int>): MutableList<Int> {
    if (list.size <= 1) {
        return list
    }

    val middleIndex = list.size / 2
    val leftList = list.subList(0, middleIndex)
    val rightList = list.subList(middleIndex, list.size)

    return merge(mergeSort(leftList), mergeSort(rightList))
}

fun merge() {} // @TODO: Implement
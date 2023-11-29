// The Fisher-Yates Shuffle is an algorithm for generating a random permutation of a finite sequence - in plain terms, for randomly shuffling the sequence.
// The algorithm runs in O(n) time and is unbiased, meaning every permutation is equally likely.

// Imagine you are creating a digital card game and need to shuffle the deck of cards randomly.
// The Fisher-Yates Shuffle Algorithm is an efficient way to randomly shuffle the elements in an array, ensuring each possible permutation is equally likely.
// This algorithm is also commonly used in algorithms that need random sampling, like in generating a random playlist from a set of songs.

fun <T> shuffle(array: Array<T>) {
    val rnd = java.util.Random()

    for (i in array.indices.reversed()) {
        val index = rnd.nextInt(i + 1)

        // Simple swap
        val a = array[index]
        array[index] = array[i]
        array[i] = a
    }
}

fun main() {
    val deckOfCards = arrayOf("Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2")
    shuffle(deckOfCards)
    println("Shuffled Deck: ${deckOfCards.joinToString(", ")}")
}

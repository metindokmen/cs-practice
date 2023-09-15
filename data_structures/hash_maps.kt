// A hash table is a data structure that allows fast data retrieval based on a key.
// It uses a hash function to compute an index into an array of slots from which the desired value can be found.

// A HashMap is an implementation of a hash table. It allows us to store key-value pairs where the key is unique.

// Think of a huge library with thousands of books. Books are categorized using unique ISBN numbers (keys).
// We don't sequentially search through every shelf. Instead, we use the ISBN to directly locate the shelf and the position of a particular book.
// Converting an ISBN into a shelf and position is like the hashing process.

// Key components of a hash map are:
// 1. Key: The unique identifier used to locate the data (e.g. ISBN)
// 2. Value: The data we want to store or retrieve (e.g. the book shelf)
// 3. Hash Function: A function that takes in a key and returns an index in the hash table where the value is to be found or placed.
// 4. Buckets/Slots: Individual storage spaces in the hash table.

fun main() {
    // Initialize the hash table
    val bookCollection = hashMapOf<String, String>()

    // Add books to the collection
    bookCollection["978-1234567890"] = "Moby Dick"
    bookCollection["978-0987654321"] = "Pride and Prejudice"

    // Retrieve a book by its ISBN
    val isbn = "978-1234567890"
    val bookTitle = bookCollection[isbn]
    println("The book with ISBN $isbn is titled '$bookTitle'")
}
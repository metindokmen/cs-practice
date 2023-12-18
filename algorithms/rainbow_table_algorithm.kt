// A Rainbow Table is a data structure that's used to speed up the process of determining the plaintext input that corresponds to a given hash output.
// It's essentially a trade-off between time and space:
// by stroing precomputed hashes of possible plaintexts,
// you can quickly find the matching plaintext for a given hash,
// as long as the plaintext exists in your table.

// Imagine you're working in cybersecurity, and you encounter a database breach where passwords are stored as hash values.
// To find out the actual passwords, you might consider a brute-force attack, but it's highly time-consuming.
// A Rainbow Table offers a more efficient method.
// It's precomputed table for reversing cryptographic hash functions, primarily used for cracking password hashes.
// By using a Rainbow Table, you can quickly look up the corresponding plaintext for a given hash.

import java.security.MessageDigest

fun String.toMD5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(this.toByteArray())
    return digest.joinToString("") { "%02x".format(it) }
}

fun createRainbowTable(words: List<String>): Map<String, String> {
    val table = mutableMapOf<String, String>()
    for (word in words) {
        table[word.toMD5()] = word
    }
    return table
}

fun main() {
    val words = listOf("password", "123456", "12345678", "password1", "qwerty")
    val rainbowTable = createRainbowTable(words)

    // Example of using the table
    val hashToCrack = "5f4dcc3b5aa765d61d8327deb882cf99" // MD5 for "password"
    println("Cracked Password: ${rainbowTable(hashToCrack)}")
}

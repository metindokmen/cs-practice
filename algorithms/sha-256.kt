// SHA-256 operates by taking an input message of arbitrary length and producing a fixed-size (256-bit) hash value.
// It uses a series of modular arithmetic and bitwise operations to process blocks of the input message and generate the hash value.
// SHA-256 is designed to be collision-resistant, meaning it's computationally infeasible to find two different inputs that produce the same hash output.

// Consider a scenario where you want to securely store user passwords in a database.
// Instead of storing passwords in plain text, you can use SHA-256 to generate hash values of passwords before storing them.
// This way, even if the database is compromised, attackers cannot retrieve the original passwords from the hash values.

import java.security.MessageDigest

fun sha256(input: String): String {
    val digest = MessageDigest.getInstance("SHA-256")
    val hashBytes = digest.digest(input.toByteArray())
    return hashBytes.joinToString("") { "%02x".format(it) }
}

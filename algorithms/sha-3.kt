// SHA-3 is based on the Keccak algorithm, which was selected through a public competition organized by NIST (National Institute of Standards and Technology).
// It operates on input data of arbitrary length and produces a fixed-size hash value.
// SHA-3 uses a sponge construction and permutation-based compression function to process input data.

// Imagine you're developing a digital signature application where data integrity is crucial.
// You can use SHA-3 to generate hash values of documents before signing them.
// This ensures that any tampering with the document can be detected, as even a small change in the document will result in a completely different hash value.

import java.security.MessageDigest

fun sha3(input: String): String {
    val digest = MessageDigest.getInstance("SHA3-256")
    val hashBytes = digest.digest(input.toByteArray())
    return hashBytes.joinToString("") { "%02x".format(it) }
}

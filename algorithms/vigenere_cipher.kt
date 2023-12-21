// The Vigenere Cipher is a method of encrypting alphabetic text by using a simple form of polyalphabetic substitution.
// A keyword is used to determine the shift for each letter in the plaintext.
// For each letter in the plaintext, you shift it by the number of positions indicated by the corresponding letter in the keyword, repeating the keyword as necessary.

// Imagine you're sending confidential messages in a scenario where basic encryption is needed.
// While simple ciphers like Caesar's cipher are easy to break due to their predictability, the Vigenere Cipher provides a more secure alternative.
// It uses a keyword to vary the shift of each letter in the plaintext, making it less susceptible to traditional frequency analysis attacks.

fun vigenereCipherEncrypt(text: String, keyword: String): String {
    val adjustedKey = keyword.toUpperCase().repeat((text.length / keyword.length) + 1)
    return text.toUpperCase().mapIndexed { index, c ->
        if (c in 'A'..'Z') {
            val shift = adjustedKey[index] - 'A'
            val shiftedChar = c + shift
            if (shiftedChar > 'Z') shiftedChar - 26 else shiftedChar
        } else {
            c
        }
    }.joinToString("")
}

fun vigenereCipherDecrypt(cipherText: String, keyword: String): String {
    val adjustedKey = keyword.toUpperCase().repeat((cipherText.length / keyword.length) + 1)
    return cipherText.mapIndexed { index, c ->
        if (c in 'A'..'Z') {
            val shift = adjustedKey[index] - 'A'
            val shiftedChar = c - shift
            if (shiftedChar < 'A') shiftedChar + 26 else shiftedChar
        } else {
            c
        }
    }.joinToString("")
}

// Rijndael Encryption Algorithm, commonly known as Advanced Encryption Standard (AES), operates on blocks of data, with key sizes of 128, 192, or 256 bits.
// It consists of several rounds of substitution, permutation, and linear transformation operations.
// These operations are applied in a specific sequence to transform plaintext into ciphertext, and vice versa, using the same key.

// Consider a scenario where you need to securely transfer confidential information, such as financial transactions or personal data, over the internet.
// AES can be employed to encrypt this data before transmission, ensuring its confidentiality even if intercepted by malicious entities.

import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

fun encrypt(text: String, key: SecretKey): String {
    val cipher = Cipher.getInstance("AES")
    cipher.init(Cipher.ENCRYPTION_MODE, key)
    val encryptedBytes = cipher.doFinal(text.toByteArray())
    return Base64.getEncoder().encodeToString(encryptedBytes)
}

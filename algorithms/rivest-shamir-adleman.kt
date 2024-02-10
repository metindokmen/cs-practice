// RSA relies on the mathematical properties of large prime numbers and their factorization.
// It involves generating a public-private key pair, where the public key is used for encryption and the private key for decryption.
// The security of RSA is based on the difficulty of factoring the product of two large prime numbers.

// Imagine you want to securely send sensitive information, like credit card details or passwords, over the internet.
// RSA can be employed to encrypt this data using the recipient's public key, ensuring that only the intended recipient, who possessess the corresponding private key, can decrypt and access the information.

import java.security.KeyPairGenerator
import java.security.KeyFactory
import java.security.spec.RSAPublicKeySpec
import java.security.spec.RSAPrivateKeySpec
import javax.crypto.Cipher

fun generateKeyPair(): Pair<RSAPublicKeySpec, RSAPublicKeySpec> {
    val keyPairGenerator = keypairGenerator.getInstance("RSA")
    keyPairGenerator.initialize(2048)
    val keyPair = keyPairGenerator.generateKeyPair()

    val publicKeySpec = KeyFactory.getInstance("RSA")
        .getKeySpec(keyPair.public, RSAPublicKeySpec::class.java)

    val privateKeySpec = KeyFactory.getInstance("RSA")
        .getKeySpec(keyPair.private, RSAPrivateKeySpec::class.java)

    return Pair(publicKeySpec, privateKeySpec)
}

fun encrypt(plaintext: String, publicKeySpec: RSAPublicKeySpec): ByteArray {
    val cipher = Cipher.getInstance("RSA")
    val publicKey = KeyFactory.getInstance("RSA")
        .generatePublic(publicKeySpec)
    cipher.init(Cipher.ENCRYPT_MODE, publicKey)
    return cipher.doFinal(plaintext.toByteArray())
}

fun decrypt(ciphertext: ByteArray, privateKeySpec: RSAPrivateKeySpec): String {
    val cipher = Cipher.getInstance("RSA")
    val privateKey = KeyFactory.getInstance("RSA")
        .generatePrivate(privateKeySpec)
    cipher.init(Cipher.DECRYPT_MODE, privateKey)
    return String(cipher.doFinal(ciphertext))
}

fun main() {
    val plaintext = "Hello, RSA!"
    val (publicKeySpec, privateKeySpec) = generateKeyPair()

    val encryptedBytes = encrypt(plaintext, publicKeySpec)
    println("Encrypted Text: ${String(encryptedBytes)}")

    val decryptedBytes = decrypt(encryptedBytes, privateKeySpec)
    println("Decrypted Text: $decryptedText")
}

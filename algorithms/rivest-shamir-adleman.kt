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

package com.example.rsa

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher

object RSAEncryption {

    // Generate RSA Key Pair
    fun generateKeyPair(): KeyPair {
        val keyGen = KeyPairGenerator.getInstance("RSA")
        keyGen.initialize(2048) // Key size
        return keyGen.generateKeyPair()
    }

    // Encrypt message using the public key
    fun encryptWithPublicKey(publicKey: PublicKey, message: String): ByteArray {
        val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        return cipher.doFinal(message.toByteArray(Charsets.UTF_8))
    }

    // Decrypt message using the private key
    fun decryptWithPrivateKey(privateKey: PrivateKey, encryptedMessage: ByteArray): String {
        val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        cipher.init(Cipher.DECRYPT_MODE, privateKey)
        return String(cipher.doFinal(encryptedMessage), Charsets.UTF_8)
    }
}

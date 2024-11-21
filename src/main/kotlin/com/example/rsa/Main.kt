package com.example.rsa

import java.util.Base64

fun main() {
    // Step 1: Generate RSA Key Pair
    val keyPair = RSAEncryption.generateKeyPair()
    val publicKey = keyPair.public
    val privateKey = keyPair.private

    // Step 2: Message to be encrypted
    val message = "Hello, RSA with PKCS1Padding!"

    // Step 3: Encrypt the message
    val encryptedMessage = RSAEncryption.encryptWithPublicKey(publicKey, message)
    val encryptedBase64 = Base64.getEncoder().encodeToString(encryptedMessage)
    println("Encrypted Message (Base64): $encryptedBase64")

    // Step 4: Decrypt the message
    val decryptedMessage = RSAEncryption.decryptWithPrivateKey(privateKey, encryptedMessage)
    println("Decrypted Message: $decryptedMessage")
}

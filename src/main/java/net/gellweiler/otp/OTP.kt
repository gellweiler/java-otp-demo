package net.gellweiler.otp

object OTP {
    var ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    /**
     * Shift the given character in text by offset.
     */
    @JvmStatic
    fun shiftChar(text: Char, offset: Int): Char {
        var newIndex = ALPHABET.indexOf(text) + offset
        if (newIndex >= ALPHABET.length) {
            newIndex = newIndex - ALPHABET.length
        } else if (newIndex < 0) {
            newIndex = newIndex + ALPHABET.length
        }
        return ALPHABET[newIndex]
    }

    /**
     * Encrypt the text character with the key character.
     */
    @JvmStatic
    fun encryptChar(text: Char, key: Char): Char {
        return shiftChar(text, ALPHABET.indexOf(key))
    }

    /**
     * Decrypt the text character with the key character.
     */
    @JvmStatic
    fun decryptChar(text: Char, key: Char): Char {
        return shiftChar(text, -ALPHABET.indexOf(key))
    }

    /**
     * Encrypt text with key.
     */
    @JvmStatic
    fun encrypt(key: String, text: String): String {
        var output = ""
        for (i in 0 until text.length) {
            output += encryptChar(text[i], key[i % key.length])
        }
        return output
    }

    /**
     * Decrypt text with key.
     */
    @JvmStatic
    fun decrypt(key: String, text: String): String {
        var output = ""
        for (i in 0 until text.length) {
            output += decryptChar(text[i], key[i % key.length])
        }
        return output
    }
}
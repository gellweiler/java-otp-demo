package net.gellweiler.otp

import net.gellweiler.otp.OTP.decrypt
import net.gellweiler.otp.OTP.decryptChar
import net.gellweiler.otp.OTP.encrypt
import net.gellweiler.otp.OTP.encryptChar
import net.gellweiler.otp.OTP.shiftChar
import org.junit.Assert
import org.junit.Test

class OTPTest {
    @Test
    fun shiftCharSimple() {
        Assert.assertEquals('B'.toLong(), shiftChar('A', 1).toLong())
        Assert.assertEquals('D'.toLong(), shiftChar('A', 3).toLong())
        Assert.assertEquals('X'.toLong(), shiftChar('X', 0).toLong())
    }

    @Test
    fun shiftCharWithOverflow() {
        Assert.assertEquals('A'.toLong(), shiftChar('Z', 1).toLong())
        Assert.assertEquals('B'.toLong(), shiftChar('Y', 3).toLong())
    }

    @Test
    fun shiftCharWithUnderflow() {
        Assert.assertEquals('Z'.toLong(), shiftChar('A', -1).toLong())
        Assert.assertEquals('Y'.toLong(), shiftChar('B', -3).toLong())
    }

    @Test
    fun encryptChar() {
        Assert.assertEquals('D'.toLong(), encryptChar('D', 'A').toLong())
        Assert.assertEquals('A'.toLong(), encryptChar('Z', 'B').toLong())
        Assert.assertEquals('B'.toLong(), encryptChar('X', 'E').toLong())
    }

    @Test
    fun decryptChar() {
        Assert.assertEquals('D'.toLong(), decryptChar('D', 'A').toLong())
        Assert.assertEquals('Z'.toLong(), decryptChar('A', 'B').toLong())
        Assert.assertEquals('X'.toLong(), decryptChar('B', 'E').toLong())
    }

    @Test
    fun encryptOTP() {
        val secret = "GEHEIMNIS"
        val key = "ABCDEFGHI"
        val encrypted = encrypt(key, secret)
        Assert.assertEquals("GFJHMRTPA", encrypted)
    }

    @Test
    fun decryptOTP() {
        val key = "ABCDEFGHI"
        val encrypted = "GFJHMRTPA"
        val secret = decrypt(key, encrypted)
        Assert.assertEquals("GEHEIMNIS", secret)
    }

    @Test
    fun encryptVigenere() {
        val secret = "GEHEIMNIS"
        val key = "ABC"
        val encrypted = encrypt(key, secret)
        Assert.assertEquals("GFJEJONJU", encrypted)
    }

    @Test
    fun decryptVigenere() {
        val encrypted = "GFJEJONJU"
        val key = "ABC"
        val secret = decrypt(key, encrypted)
        Assert.assertEquals("GEHEIMNIS", secret)
    }
}
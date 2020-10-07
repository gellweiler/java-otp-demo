package net.gellweiler.otp

import kotlin.jvm.JvmStatic
import javax.swing.JOptionPane
import net.gellweiler.otp.OTP
import java.lang.Exception

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val text = JOptionPane.showInputDialog("Please enter the text you want to decrypt/encrypt:")
            val key = JOptionPane.showInputDialog("Please enter the key you want to use for decryption/encryption:")
            JOptionPane.showMessageDialog(null, "Encryption: " + OTP.encrypt(key, text))
            JOptionPane.showMessageDialog(null, "Decryption: " + OTP.decrypt(key, text))
        } catch (e: Exception) {
            System.err.println("Error: " + e.message)
        }
    }
}
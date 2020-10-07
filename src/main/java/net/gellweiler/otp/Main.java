package net.gellweiler.otp;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String text = JOptionPane.showInputDialog("Please enter the text you want to decrypt/encrypt:");
            String key = JOptionPane.showInputDialog("Please enter the key you want to use for decryption/encryption:");

            JOptionPane.showMessageDialog(null, "Encryption: " + OTP.encrypt(key, text));
            JOptionPane.showMessageDialog(null, "Decryption: " + OTP.decrypt(key, text));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

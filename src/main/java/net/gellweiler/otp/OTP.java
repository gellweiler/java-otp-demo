package net.gellweiler.otp;

public class OTP {
    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Shift the given character in text by offset.
     */
    public static char shiftChar(char text, int offset) {
        int newIndex = ALPHABET.indexOf(text) + offset;

        if (newIndex >= ALPHABET.length()) {
            newIndex = newIndex - ALPHABET.length();
        } else if (newIndex < 0) {
            newIndex = newIndex + ALPHABET.length();
        }

        return ALPHABET.charAt(newIndex);
    }

    /**
     * Encrypt the text character with the key character.
     */
    public static char encryptChar(char text, char key) {
        return shiftChar(text, ALPHABET.indexOf(key));

    }

    /**
     * Decrypt the text character with the key character.
     */
    public static char decryptChar(char text, char key) {
        return shiftChar(text, -ALPHABET.indexOf(key));
    }

    /**
     * Encrypt text with key.
     */
    public static String encrypt(String key, String text) {
        String output = "";

        for (int i = 0; i < text.length(); i++) {
            output += encryptChar(text.charAt(i), key.charAt(i % key.length()));
        }

        return output;
    }

    /**
     * Decrypt text with key.
     */
    public static String decrypt(String key, String text) {
        String output = "";

        for (int i = 0; i < text.length(); i++) {
            output += decryptChar(text.charAt(i), key.charAt(i % key.length()));
        }

        return output;
    }
}

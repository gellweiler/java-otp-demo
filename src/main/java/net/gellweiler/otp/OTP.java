package net.gellweiler.otp;

public class OTP {
    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String key, String text) {
        String output = "";

        for (int i = 0; i < text.length(); i++) {
            char cKey = key.charAt(i);
            char cText = text.charAt(i);

            int newIndex = (ALPHABET.indexOf(cText) + ALPHABET.indexOf(cKey)) % ALPHABET.length();
            output += ALPHABET.charAt(newIndex);
        }

        return output;
    }

    public static String decrypt(String key, String text) {
        String output = "";

        for (int i = 0; i < text.length(); i++) {
            char cKey = key.charAt(i);
            char cText = text.charAt(i);

            int newIndex = (ALPHABET.indexOf(cText) - ALPHABET.indexOf(cKey) + ALPHABET.length()) % ALPHABET.length();
            output += ALPHABET.charAt(newIndex);
        }

        return output;
    }
}

package net.gellweiler.otp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OTPTest {

    @Test
    public void shiftCharSimple() {
        Assert.assertEquals('B', OTP.shiftChar('A', 1));
        Assert.assertEquals('D', OTP.shiftChar('A', 3));
        Assert.assertEquals('X', OTP.shiftChar('X', 0));
    }

    @Test
    public void shiftCharWithOverflow() {
        Assert.assertEquals('A', OTP.shiftChar('Z', 1));
        Assert.assertEquals('B', OTP.shiftChar('Y', 3));
    }

    @Test
    public void shiftCharWithUnderflow() {
        Assert.assertEquals('Z', OTP.shiftChar('A', -1));
        Assert.assertEquals('Y', OTP.shiftChar('B', -3));
    }

    @Test
    public void encryptChar() {
        Assert.assertEquals('D', OTP.encryptChar('D', 'A'));
        Assert.assertEquals('A', OTP.encryptChar('Z', 'B'));
        Assert.assertEquals('B', OTP.encryptChar('X', 'E'));
    }

    @Test
    public void decryptChar() {
        Assert.assertEquals('D', OTP.decryptChar('D', 'A'));
        Assert.assertEquals('Z', OTP.decryptChar('A', 'B'));
        Assert.assertEquals('X', OTP.decryptChar('B', 'E'));
    }

    @Test
    public void encryptOTP() {
        String secret = "GEHEIMNIS";
        String key    = "ABCDEFGHI";

        String encrypted = OTP.encrypt(key, secret);

        Assert.assertEquals("GFJHMRTPA", encrypted);
    }

    @Test
    public void decryptOTP() {
        String key    = "ABCDEFGHI";
        String encrypted = "GFJHMRTPA";

        String secret = OTP.decrypt(key, encrypted);

        Assert.assertEquals("GEHEIMNIS", secret);
    }

    @Test
    public void encryptVigenere() {
        String secret = "GEHEIMNIS";
        String key    = "ABC";

        String encrypted = OTP.encrypt(key, secret);

        Assert.assertEquals("GFJEJONJU", encrypted);
    }

    @Test
    public void decryptVigenere() {
        String encrypted = "GFJEJONJU";
        String key    = "ABC";

        String secret = OTP.decrypt(key, encrypted);

        Assert.assertEquals("GEHEIMNIS", secret);
    }
}
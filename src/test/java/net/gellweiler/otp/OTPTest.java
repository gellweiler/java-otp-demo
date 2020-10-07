package net.gellweiler.otp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OTPTest {

    @Test
    public void encrypt() {
        String secret = "GEHEIMNIS";
        String key    = "ABCDEFGHI";

        String encrypted = OTP.encrypt(key, secret);

        Assert.assertEquals("GFJHMRTPA", encrypted);
    }

    @Test
    public void decrypt() {
        String key    = "ABCDEFGHI";
        String encrypted = "GFJHMRTPA";

        String secret = OTP.decrypt(key, encrypted);

        Assert.assertEquals("GEHEIMNIS", secret);
    }
}
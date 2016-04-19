package com.focuslabs.wts.libs;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by baba on 4/18/2016.
 */
public class Encription {

    public static String encrypt(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(password.getBytes());
        return new BASE64Encoder().encode(messageDigest.digest());
    }

    public static boolean checkEqual(String text,String hash) throws NoSuchAlgorithmException {
        return encrypt(text).equals(hash) ? true : false;
    }

}

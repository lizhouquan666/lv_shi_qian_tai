package com.wanxi.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tool {
    public static Integer stringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return -1;
        }

    }

    public static String nullToString(String value) {
        return value == null ? "" : value;
    }

    public static Integer enableToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return -10;
        }

    }

    public static Integer pageToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 1;
        }

    }

    public static Integer limitToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 10;
        }

    }

    /**
     * 利用MD5进行加密
     */
    public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}

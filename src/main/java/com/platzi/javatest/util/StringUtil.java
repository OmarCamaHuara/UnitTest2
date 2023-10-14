package com.platzi.javatest.util;

public class StringUtil {

    public StringUtil() {
    }

    public static String repeat(String str, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result +=str;
        }
        return result;
    }

    public static boolean isEmpty(String str){
        return str == null || str.trim().length() <= 0;
    }
}

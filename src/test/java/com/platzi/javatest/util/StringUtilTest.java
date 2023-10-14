package com.platzi.javatest.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

//    public static void main(String[] args) {
//        String result = StringUtil.repeat("Hola", 3);
//        System.out.println(result);
//
//    }
    StringUtil stringUtil;

    public void setup(){
        stringUtil = new StringUtil();
    }

    @Test
    void when_is_string_null(){
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    void when_string_is_empty(){
        assertTrue(stringUtil.isEmpty(""));
    }

    @Test
    void when_string_have_word(){
        assertFalse(stringUtil.isEmpty("Omar"));
    }

    @Test
    void when_string_is_empty_with_space(){
        assertTrue(stringUtil.isEmpty(" "));
    }

}
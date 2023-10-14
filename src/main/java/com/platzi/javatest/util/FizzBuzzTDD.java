package com.platzi.javatest.util;

public class FizzBuzzTDD {

    public static String methodFizzBuzz(final int number) {

        String result = "";

        if (number % 3 == 0){
            result += "Fizz";
        }

        if (number % 5 == 0){
            result += "Buzz";
        }

        return result.isEmpty() ? String.valueOf(number) :result;
    }
}

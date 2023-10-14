package com.platzi.javatest.util;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTDDTest {

    @Test
    void return_fizz_if_the_number_is_divisible_by_three(){
        assertThat(FizzBuzzTDD.methodFizzBuzz(36), is("Fizz"));
        assertThat(FizzBuzzTDD.methodFizzBuzz(33), is("Fizz"));
        assertThat(FizzBuzzTDD.methodFizzBuzz(18), is("Fizz"));
    }

    @Test
    void return_buzz_if_the_number_is_divisible_by_five(){
        assertThat(FizzBuzzTDD.methodFizzBuzz(35), is("Buzz"));
        assertThat(FizzBuzzTDD.methodFizzBuzz(100), is("Buzz"));
        assertThat(FizzBuzzTDD.methodFizzBuzz(25), is("Buzz"));
    }

    @Test
    void return_fizzbuzz_if_the_number_is_divisible_by_five_and_three(){
        assertThat(FizzBuzzTDD.methodFizzBuzz(15), is("FizzBuzz"));
        assertThat(FizzBuzzTDD.methodFizzBuzz(30), is("FizzBuzz"));
        assertThat(FizzBuzzTDD.methodFizzBuzz(45), is("FizzBuzz"));
    }

    void return_the_same_number_in_another_case(){
        assertThat(FizzBuzzTDD.methodFizzBuzz(11), is("11"));
        assertThat(FizzBuzzTDD.methodFizzBuzz(51), is("51"));
        assertThat(FizzBuzzTDD.methodFizzBuzz(101), is("101"));
    }

}
package com.platzi.javatest.discounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

class PriceCalculatorShould {

    PriceCalculator calculator;

    @BeforeEach
    void setup(){
        calculator = new PriceCalculator();
    }

    @Test
    void total_zero_when_there_are_price(){
        //PriceCalculator calculator = new PriceCalculator();

        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    void total_is_the_sum_of_prices(){
        //PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(13.4);
        calculator.addPrice(23.4);

        assertThat(calculator.getTotal(), is(36.8));
    }

    @Test
    void apply_discount_to_prices(){
        //PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(100.0);
        calculator.addPrice(50.0);
        calculator.addPrice(50.0);

        calculator.setDiscount(25);

        assertThat(calculator.getTotal(), is(150.0));
    }

}
package com.platzi.javatest.payments;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @BeforeEach
    public void setup() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        // subiriam aqui por ela sera llamanda antes que aconteca um test
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    void payment_is_correct() {

        // PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class); subimos estas declaracoes que sao iguais
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        // PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        assertTrue(paymentProcessor.makePaymente(1000));
    }

    @Test
    void payment_is_wrong() {
        // PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class); subimos estas declaracoes que sao iguais
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        // PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        assertFalse(paymentProcessor.makePaymente(1000));
    }
}
package com.platzi.javatest.payments;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(final PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePaymente(double amout){
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amout));
        if (response.getStatus() == PaymentResponse.PaymentStatus.OK) {
            return true;
        } else {
            return false;
        }
    }
}

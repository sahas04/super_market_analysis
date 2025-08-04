package model;

public class PaymentMethod {
    private int payment_id;
    private String paymentmethod;

    public PaymentMethod() {
    }

    public PaymentMethod(int payment_id, String paymentmethod) {
        this.payment_id = payment_id;
        this.paymentmethod = paymentmethod;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "payment_id=" + payment_id +
                ", paymentmethod='" + paymentmethod + '\'' +
                '}';
    }
}

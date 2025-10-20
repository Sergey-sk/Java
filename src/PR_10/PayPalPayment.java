package PR_10;

public class PayPalPayment implements Payment{
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("PayPal оплата с email %s, на сумму: %.2f%n", email, amount);
        return true;
    }

    @Override
    public String getType() {
        return "PAYPAL";
    }
}

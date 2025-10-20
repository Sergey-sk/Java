package PR_9;

public class PayPalPayment implements Payment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("Оплата в размере %.2f прошла успешно с Paypal аккаунта %s", amount, email);
        return true;
    }
}

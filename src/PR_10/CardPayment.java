package PR_10;

public class CardPayment implements Payment{
    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("Оплата картой: %s, на сумму: %.2f", cardNumber, amount);

        return true;
    }

    @Override
    public String getType() {
        return "CARD";
    }
}

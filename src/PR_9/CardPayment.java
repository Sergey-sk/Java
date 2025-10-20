package PR_9;

public class CardPayment implements Payment {
    private String cardNum;

    public CardPayment(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("Оплата кредитной картой номер %s в размере %.2f прошла успешно", cardNum, amount);
        return true;
    }
}

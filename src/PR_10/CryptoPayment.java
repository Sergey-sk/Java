package PR_10;

public class CryptoPayment implements Payment{
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }


    @Override
    public boolean pay(double amount) {
        System.out.printf("Крипто оплата с кошелька %s, на сумму: %.2f", walletAddress, amount);
        return true;
    }

    @Override
    public String getType() {
        return "CRYPTO";
    }
}

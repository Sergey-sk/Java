package PR_10;

public class PaymentManager {
    private static PaymentManager instance;

    private PaymentManager(){
        System.out.println("PaymentManager инициализирован!");
    }

    public static PaymentManager getInstance(){
        if (instance == null){
            instance = new PaymentManager();
        }

        return instance;
    }

    public Payment createPayment(PaymentType type, String... params){
        switch (type){
            case CARD:
                if (params.length < 1) throw new IllegalArgumentException("Необходим номер карты!");

                return new CardPayment(params[0]);

            case PAYPAL:
                if (params.length < 1) throw new IllegalArgumentException("Необходим email!");

                return new PayPalPayment(params[0]);

            case CRYPTO:
                if (params.length < 1) throw new IllegalArgumentException("Необходим адрес кошелька!");

                return new CryptoPayment(params[0]);

            default:
                throw new IllegalArgumentException("Неизвестный тип оплаты " + type);
        }
    }

    public boolean processPayment(PaymentType type, double amount, String... params){
        Payment payment = createPayment(type, params);
        System.out.println("Создан платеж типа " + payment.getType());
        return payment.pay(amount);
    }
}

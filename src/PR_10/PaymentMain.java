package PR_10;

public class PaymentMain {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА ОПЛАТЫ ===\n");

        // Получаем единственный экземпляр PaymentManager
        PaymentManager paymentManager = PaymentManager.getInstance();

        // Тестируем различные способы оплаты
        System.out.println("1. ОПЛАТА КАРТОЙ:");
        Payment cardPayment = paymentManager.createPayment(PaymentType.CARD, "1234567812345678");
        cardPayment.pay(1500.50);

        System.out.println("\n2. PAYPAL ОПЛАТА:");
        Payment paypalPayment = paymentManager.createPayment(PaymentType.PAYPAL, "user@example.com");
        paypalPayment.pay(2999.99);

        System.out.println("\n3. КРИПТО ОПЛАТА:");
        Payment cryptoPayment = paymentManager.createPayment(
                PaymentType.CRYPTO, "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
        cryptoPayment.pay(0.05);

        System.out.println("\n4. ПРЯМАЯ ОБРАБОТКА ЧЕРЕЗ MANAGER:");
        paymentManager.processPayment(PaymentType.CARD, 750.25, "5555666677778888");

        // Проверяем Singleton
        System.out.println("\n5. ПРОВЕРКА SINGLETON:");
        PaymentManager anotherInstance = PaymentManager.getInstance();
        System.out.println("Один и тот же экземпляр? " + (paymentManager == anotherInstance));

        System.out.println("\n=== ВСЕ ОПЕРАЦИИ ЗАВЕРШЕНЫ ===");
    }
}

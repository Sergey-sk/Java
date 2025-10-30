package PR_14;

public class ListenerDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        CartDisplayListener displayListener = new CartDisplayListener();

        cart.addCartListener(displayListener);

        cart.addProduct("Смартфон", 29999.99, 1);
        cart.addProduct("Наушники", 2499.50, 2);
        cart.addProduct("Чехол для телефона", 899.00, 1);
        cart.addProduct("USB-кабель", 499.00, 3);

        System.out.println("\nКорзина");
        System.out.println("Общее количество товаров: " + cart.getTotalItems());
        System.out.println("Общая стоимость: " + String.format("%.2f", cart.getTotalAmount()) + " руб.");

        System.out.println("\nОчистка корзины");
        cart.clearCart();
        System.out.println("Товаров в корзине: " + cart.getTotalItems());
        System.out.println("Общая сумма: " + cart.getTotalAmount() + " руб.");
    }
}

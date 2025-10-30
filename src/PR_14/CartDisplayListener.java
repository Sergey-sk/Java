package PR_14;

public class CartDisplayListener implements CartListener{
    @Override
    public void addProductToCart(ProductAddedToCartEvent event) {
        System.out.println("Название товара: " + event.getProductName());
        System.out.println("Цена товара за единицу: " + event.getProductPrice());
        System.out.println("Кол-во товаров: " + event.getQuantity());
        System.out.println("Общая стоимость: " + event.getTotalPrice());
        System.out.println();
    }
}

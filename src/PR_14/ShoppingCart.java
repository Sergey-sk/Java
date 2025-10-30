package PR_14;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartListener> listeners = new ArrayList<>();
    private List<ProductAddedToCartEvent> cartItems = new ArrayList<>();
    private double totalAmount = 0.0;
    private int totalItems = 0;

    public void addCartListener(CartListener listener){
        listeners.add(listener);
    }

    public void removeCartListener(CartListener listener){
        listeners.remove(listener);
    }

    public void addProduct(String productName, double price, int quantity){
        ProductAddedToCartEvent event = new ProductAddedToCartEvent(this, productName, price, quantity);

        cartItems.add(event);
        totalItems += quantity;
        totalAmount += event.getTotalPrice();

        notifyListener(event);
    }

    private void notifyListener(ProductAddedToCartEvent event) {
        listeners.forEach(listener -> listener.addProductToCart(event));
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public List<ProductAddedToCartEvent> getCartItems() {
        return cartItems;
    }

    public void clearCart(){
        cartItems.clear();
        totalAmount = 0.0;
        totalItems = 0;
    }
}

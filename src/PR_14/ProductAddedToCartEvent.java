package PR_14;

import java.util.EventObject;

public class ProductAddedToCartEvent extends EventObject {
    private String productName;
    private double productPrice;
    private int quantity;

    public ProductAddedToCartEvent(Object source, String productName, double productPrice, int quantity) {
        super(source);
        this.productName = productName ;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice(){
        return productPrice * quantity;
    }
}

package PR_14;

import java.util.EventListener;

public interface CartListener extends EventListener {
    void  addProductToCart(ProductAddedToCartEvent event);
}

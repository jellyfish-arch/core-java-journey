package ecommerce_cart;
import java.util.*;

public class Cart {
    
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void showCart() {
        for (CartItem item : items) {
            System.out.println(item);
        }
    }

}

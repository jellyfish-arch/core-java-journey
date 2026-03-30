package ecommerce_cart;
import java.util.*;

public class Cart {
    
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {

        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public void showCart() {
        for (CartItem item : items) {
            System.out.println(item);
        }
    }

    public double getTotal() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

}

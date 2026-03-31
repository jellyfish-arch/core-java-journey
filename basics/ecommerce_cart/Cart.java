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

    public void removeItem(int productId) {

        Iterator<CartItem> iterator = items.iterator();

        while (iterator.hasNext()) {
            CartItem item = iterator.next();

            if (item.getProduct().getId() == productId) {
                iterator.remove();
                System.out.println("Item removed");
                return;
            }
        }

        System.out.println("Product not found in cart");
    }

    public double getTotal() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

}

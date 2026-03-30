package ecommerce_cart;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart();

        Product p1 = new Product(1, "Laptop", 50000.0);
        Product p2 = new Product(2, "Mouse", 500.0);

        cart.addItem(p1, 1);
        cart.addItem(p1, 1);
        cart.addItem(p1, 2); // should merge
        cart.addItem(p2, 2);

        cart.showCart();
        System.out.println("Total: " + cart.getTotal());
    }
}

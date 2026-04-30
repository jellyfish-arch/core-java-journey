package inventory_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added: " + product.getName());
    }

    public void removeProduct(String id) {
        products.removeIf(p -> p.getId().equals(id));
        System.out.println("Product removed if it existed.");
    }

    public Optional<Product> findProduct(String id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Product> getLowStockProducts(int threshold) {
        return products.stream()
                .filter(p -> p.getQuantity() < threshold)
                .collect(Collectors.toList());
    }

    public void displayInventory() {
        System.out.println("--- Current Inventory ---");
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            products.forEach(System.out::println);
        }
        System.out.println("-------------------------");
    }
}

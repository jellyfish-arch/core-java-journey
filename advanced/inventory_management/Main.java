package inventory_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        // Pre-populate some data - used this in Advanced Java section.
        inventory.addProduct(new Product("P001", "Laptop", 999.99, 10));
        inventory.addProduct(new Product("P002", "Wireless Mouse", 29.99, 50));
        inventory.addProduct(new Product("P003", "Mechanical Keyboard", 89.99, 5));

        boolean running = true;
        while (running) {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Check Low Stock");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    inventory.displayInventory();
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    inventory.addProduct(new Product(id, name, price, qty));
                    break;
                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    String removeId = scanner.nextLine();
                    inventory.removeProduct(removeId);
                    break;
                case 4:
                    System.out.print("Enter low stock threshold: ");
                    int threshold = scanner.nextInt();
                    System.out.println("Low Stock Products:");
                    inventory.getLowStockProducts(threshold).forEach(System.out::println);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

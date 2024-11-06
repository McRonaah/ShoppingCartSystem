import java.util.Scanner;

import models.Customer;
import models.Order;
import models.Product;
import models.ShoppingCart;

public class Main{
    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", 1200.00, "Electronics", 10);
        Product product2 = new Product(2, "Headphones", 150.00, "Electronics", 20);
        Product product3 = new Product(3, "Coffee Maker", 80.00, "Home Appliances", 15);
        Product product4 = new Product(4, "Book", 20.00, "Books", 50);
        Product product5 = new Product(5, "Shoes", 70.00, "Clothing", 25);

        // Initialize shopping cart
        ShoppingCart cart = new ShoppingCart();
        Customer customer = new Customer("John Doe", "john@example.com", "123 Main St");

        // User interaction loop
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Online Shopping Cart System");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewProducts(product1, product2, product3, product4, product5);
                    break;

                case 2:
                    System.out.print("Enter Product ID to add: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    addProductToCart(cart, productId, quantity, product1, product2, product3, product4, product5);
                    break;

                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = scanner.nextInt();
                    removeProductFromCart(cart, removeId, product1, product2, product3, product4, product5);
                    break;

                case 4:
                    System.out.println(cart);
                    break;

                case 5:
                    checkout(cart, customer);
                    running = false; // End loop after checkout
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
        System.out.println("Thank you for shopping with us!");
    }

    // Display products
    private static void viewProducts(Product... products) {
        System.out.println("\nAvailable Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Add product to cart
    private static void addProductToCart(ShoppingCart cart, int productId, int quantity, Product... products) {
        for (Product product : products) {
            if (product.getId() == productId) {
                cart.addItem(product, quantity);
                System.out.println(quantity + " x " + product.getName() + " added to cart.");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }

    // Remove product from cart
    private static void removeProductFromCart(ShoppingCart cart, int productId, Product... products) {
        for (Product product : products) {
            if (product.getId() == productId) {
                cart.removeItem(product);
                System.out.println(product.getName() + " removed from cart.");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }

    // Checkout and create order
    private static void checkout(ShoppingCart cart, Customer customer) {
        System.out.println("\n--- Checkout ---");
        System.out.println("Customer: " + customer);
        System.out.println(cart);
        double totalWithTax = cart.calculateTotalWithTax();
        System.out.printf("Total with tax: $%.2f\n", totalWithTax);

        Order order = new Order(customer, cart.getItems());
        order.generateConfirmation();
        System.out.println("Thank you for your order!");
    }
}
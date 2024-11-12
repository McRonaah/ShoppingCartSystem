import java.util.Scanner;

import models.ShoppingCart;
import main.java.services.CartService;
import main.java.services.OrderService;
import main.java.utils.DiscountUtils;
import main.java.utils.LoggerUtils;
import main.java.utils.ValidationUtils;
import models.Customer;
import models.Order;
import models.Product;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // Initialize services
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();

        // Sample products
        Product[] products = {
            new Product(1, "Laptop", 25000.0, "Electronics", 10),
            new Product(2, "Phone", 12000.0, "Electronics", 15),
            new Product(3, "Tablet", 7000.0, "Electronics", 5),
            new Product(4, "Book", 245.0, "Books", 100),
            new Product(5, "Pen", 95.0, "Stationery", 200)
        };

        Scanner scanner = new Scanner(System.in);
        
        // Customer details
        System.out.println("=======================================================");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.println("-------------------------------------------------------");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        if (!ValidationUtils.isValidEmail(email)) {
            LoggerUtils.logError("Invalid email format: " + email);
            System.out.println("Invalid email format. Exiting program.");
            return;
        }
        
        System.out.println("-------------------------------------------------------");
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        
        Customer customer = new Customer(name, email, address);
        
        // Initialize shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Shopping process
        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Available products:");
            for (Product product : products) {
                System.out.println(product.getId() + " - " + product.getName() + " ( KES" + product.getPrice() + ")");
            }

            // Display options
            System.out.println("-------------------------------------------------------");
            System.out.println("6. Add product to cart");
            System.out.println("7. Remove product from cart");
            System.out.println("8. View cart items");
            System.out.println("9. Check Stock");
            System.out.println("0. Checkout");
            System.out.println("-------------------------------------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) break;  // Checkout

            switch (choice) {
                case 6:
                    System.out.print("Enter product ID to add to cart: ");
                    int productIdToAdd = scanner.nextInt();
                    Product selectedProduct = ValidationUtils.findProductById(productIdToAdd, products);
                    if (selectedProduct == null) {
                        System.out.println("Product not found.");
                        continue;
                    }

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    if (!selectedProduct.isInStock(quantity)) {
                        System.out.println("Insufficient stock for this product.");
                        continue;
                    }

                    cartService.addProductToCart(cart, selectedProduct, quantity);
                    System.out.println(quantity + " " + selectedProduct.getName() + "(s) added to cart.");
                    break;

                case 7:
                    System.out.print("Enter product ID to remove from cart: ");
                    int removeProductId = scanner.nextInt();
                    Product productToRemove = ValidationUtils.findProductById(removeProductId, products);
                    if (productToRemove == null) {
                        System.out.println("Product not found.");
                        continue;
                    }
                    cartService.removeProductFromCart(cart, productToRemove);
                    System.out.println("Removed " + productToRemove.getName() + " from cart.");
                    break;

                case 8:
                    System.out.println("Items in your cart:");
                    System.out.println(cart.toString());
                    System.out.println("Total Amount (before tax): KES" + cart.getTotalAmount());
                    break;

               
                case 9:
                        System.out.println("Current stock availability:");
                        for (Product product : products) {
                            System.out.println(product.getName() + ": " + product.getStockQuantity() + " units available");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
            }
        }

        // Applying discount
        System.out.println("-------------------------------------------------------");
        System.out.print("Enter discount code (or press Enter to skip): ");
        scanner.nextLine();  // consume the remaining newline
        String discountCode = scanner.nextLine();
        
        double totalAmount = cart.calculateTotalWithTax();
        if (DiscountUtils.isValidDiscountCode(discountCode)) {
            totalAmount = cartService.applyDiscount(totalAmount, discountCode);
            System.out.println("Discount applied! New total: KES" + totalAmount);
        } else if (!discountCode.isEmpty()) {
            System.out.println("Invalid discount code.");
        }
        
        // Creating the order
        Order order = orderService.createOrder(customer, cart);
        
        // Print summary
        System.out.println("=======================================================");
        System.out.println("Order placed successfully!");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + customer.getName());
        System.out.println("Total amount: KES" + totalAmount);

        LoggerUtils.logInfo("Order created successfully for customer " + customer.getEmail());

        System.out.println("=======================================================");

        scanner.close();
    }
}

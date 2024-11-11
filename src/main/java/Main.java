
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
            new Product(1, "Laptop", 1000.0, "Electronics", 10),
            new Product(2, "Phone", 800.0, "Electronics", 15),
            new Product(3, "Tablet", 300.0, "Electronics", 5),
            new Product(4, "Book", 20.0, "Books", 100),
            new Product(5, "Pen", 1.0, "Stationery", 200)
        };

        Scanner scanner = new Scanner(System.in);
        
        // Customer details
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        if (!ValidationUtils.isValidEmail(email)) {
            LoggerUtils.logError("Invalid email format: " + email);
            System.out.println("Invalid email format. Exiting program.");
            return;
        }
        
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        
        Customer customer = new Customer(name, email, address);
        
        // Initialize shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Shopping process
        while (true) {
            System.out.println("Available products:");
            for (Product product : products) {
                System.out.println(product.getId() + " - " + product.getName() + " ($" + product.getPrice() + ")");
            }
            
            System.out.print("Enter product ID to add to cart (or 0 to checkout): ");
            int productId = scanner.nextInt();
            
            if (productId == 0) break;
            
            Product selectedProduct = ValidationUtils.findProductById(productId, products);
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
            System.out.println(quantity + " x " + selectedProduct.getName() + " added to cart.");
        }

        // Applying discount
        System.out.print("Enter discount code (or press Enter to skip): ");
        scanner.nextLine();  // consume the remaining newline
        String discountCode = scanner.nextLine();
        
        double totalAmount = cart.calculateTotalWithTax();
        if (DiscountUtils.isValidDiscountCode(discountCode)) {
            totalAmount = cartService.applyDiscount(totalAmount, discountCode);
            System.out.println("Discount applied! New total: $" + totalAmount);
        } else if (!discountCode.isEmpty()) {
            System.out.println("Invalid discount code.");
        }
        
        // Creating the order
        Order order = orderService.createOrder(customer, cart);
        // orderService.Order(order);
        
        // Print summary
        System.out.println("Order placed successfully!");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + customer.getName());
        System.out.println("Total amount: $" + totalAmount);

        LoggerUtils.logInfo("Order created successfully for customer " + customer.getEmail());

        scanner.close();
    }
}

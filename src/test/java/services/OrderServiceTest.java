package services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Import JUnit assertions

import main.java.services.OrderService;
import models.Customer;
import models.Order;
import models.Product;
import models.ShoppingCart;

public class OrderServiceTest {

    private OrderService orderService = new OrderService();

    @Test
    public void testCreateOrder() {
        Customer customer = new Customer("Alice", "alice@example.com", "123 Lane");
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product(1, "Book", 20.0, "Books", 10);
        cart.addItem(product, 1);

        Order order = orderService.createOrder(customer, cart);
        assertNotNull(order); // Checks if order is not null
        assertEquals(customer, order.getCustomer()); // Verifies the customer is correctly assigned
    }
}

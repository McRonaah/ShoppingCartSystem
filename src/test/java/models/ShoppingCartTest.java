package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    public void testAddItemToCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product(0, "Laptop", 1000.0, null, 10);
        cart.addItem(product, 1);
        assertEquals(1, cart.getItems().size());
        assertEquals(1000.0, cart.getTotalPrice());
    }

    @Test
    public void testRemoveItemFromCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product(0, "Laptop", 1000.0, null, 10);
        cart.addItem(product, 2);
        cart.removeItem(product);
        assertEquals(0, cart.getItems().size());
        assertEquals(0.0, cart.getTotalPrice());
    }

    @Test
    public void testCalculateTotalWithTax() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product(0, "Laptop", 1000.0, null, 10);
        Product product2 = new Product(1, "Phone", 500.0, null, 10);
        cart.addItem(product1, 1);
        cart.addItem(product2, 1);
        assertEquals(1500.0, cart.getTotalPrice());
        assertEquals(1620.0, cart.calculateTotalWithTax(), 0.01);
    }
}

package services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Import JUnit assertions

import models.Product;
import models.ShoppingCart;
import main.java.services.CartService;

public class CartServiceTest {

    private CartService cartService = new CartService();

    @Test
    public void testAddProductToCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product(1, "Laptop", 1200.0, "Electronics", 5);
        
        cartService.addProductToCart(cart, product, 2);
        assertTrue(cart.getItems().containsKey(product));
        assertEquals(2, cart.getItems().get(product).intValue());
    }
    
    @Test
    public void testApplyDiscount() {
        double totalAmount = 100.0;
        double discountedTotal = cartService.applyDiscount(totalAmount, "SAVE10");
        assertEquals(90.0, discountedTotal, 0.01); // Allow small delta for floating-point comparison
    }
}

package services;

import org.junit.jupiter.api.Test;

import main.java.services.CartService;
import models.Product;
import models.ShoppingCart;

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
                        
                            private void assertEquals(int i, int intValue) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
                    }
                
                            private void assertTrue(boolean containsKey) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
            }
        
            @Test
    public void testApplyDiscount() {
        double totalAmount = 100.0;
        double discountedTotal = cartService.applyDiscount(totalAmount, "SAVE10");
        assertEquals(90.0, discountedTotal, 0.01);
            }
        
                    private void assertEquals(double d, double discountedTotal, double e) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
                    }
}

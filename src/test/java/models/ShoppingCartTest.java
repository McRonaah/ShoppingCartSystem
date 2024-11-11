package models;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    public void testAddProductToCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product(0, "Laptop", 1000.0, null, 0);
        cart.addProduct(product);
        assertEquals(1, cart.getItems().size());
            }
        
            private void assertEquals(double i, int size) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
            }
        
            @Test
    public void testRemoveProductFromCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product(0, "Laptop", 1000.0, null, 0);
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(0, cart.getItems().size());
    }

    @Test
    public void testTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product(0, "Laptop", 1000.0, null, 0);
        Product product2 = new Product(0, "Phone", 500.0, null, 0);
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals(1500.0, cart.getTotalPrice());
    }
}

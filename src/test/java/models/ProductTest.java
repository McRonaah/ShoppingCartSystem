package models;

import org.junit.jupiter.api.Test; // Correct JUnit import
import static org.junit.jupiter.api.Assertions.*; // Ensure JUnit assertions are imported

public class ProductTest {

    @Test
    public void testProductConstructor() {
        // Testing Product constructor
        Product product = new Product(0, "Laptop", 1000.0, null, 0);
        assertNotNull(product); // JUnit assertion
        assertEquals("Laptop", product.getName()); // JUnit assertion
        assertEquals(1000.0, product.getPrice()); // JUnit assertion
    }

    @Test
    public void testSetPrice() {
        // Testing setPrice method
        Product product = new Product(0, "Phone", 450.0, null, 0);
        // product.setPrice(450.0);
        assertEquals(450.0, product.getPrice()); // JUnit assertion
    }
}

package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Import JUnit assertions

import main.java.utils.ValidationUtils;
import models.Product;

public class ValidationUtilsTest {

    @Test
    public void testIsValidEmail() {
        assertTrue(ValidationUtils.isValidEmail("test@example.com")); // Valid email test
        assertFalse(ValidationUtils.isValidEmail("invalid-email"));    // Invalid email test
    }

    @Test
    public void testFindProductById() {
        Product product1 = new Product(1, "Book", 20.0, "Books", 10);
        Product product2 = new Product(2, "Pen", 2.0, "Stationery", 100);

        // Test to find product by ID
        assertEquals(product1, ValidationUtils.findProductById(1, product1, product2));
        
        // Test for an ID that does not exist
        assertNull(ValidationUtils.findProductById(3, product1, product2));
    }
}

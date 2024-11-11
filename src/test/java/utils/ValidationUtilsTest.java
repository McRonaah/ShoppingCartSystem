package utils;

import org.junit.jupiter.api.Test;

import main.java.utils.ValidationUtils;
import models.Product;

public class ValidationUtilsTest {

    @Test
    public void testIsValidEmail() {
        assertTrue(ValidationUtils.isValidEmail("test@example.com"));
                assertFalse(ValidationUtils.isValidEmail("invalid-email"));
                    }
                
                    private void assertTrue(boolean validEmail) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
            }
        
                    private void assertFalse(boolean validEmail) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertFalse'");
            }
        
            @Test
    public void testFindProductById() {
        Product product1 = new Product(1, "Book", 20.0, "Books", 10);
        Product product2 = new Product(2, "Pen", 2.0, "Stationery", 100);
        
        assertEquals(product1, ValidationUtils.findProductById(1, product1, product2));
                assertNull(ValidationUtils.findProductById(3, product1, product2));
                            }
                        
                                    private void assertNull(Product productById) {
                                // TODO Auto-generated method stub
                                throw new UnsupportedOperationException("Unimplemented method 'assertNull'");
                            }
                
                                    private void assertEquals(Product product1, Product productById) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
                    }
}

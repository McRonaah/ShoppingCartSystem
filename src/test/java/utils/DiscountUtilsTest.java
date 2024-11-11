package utils;

import org.junit.jupiter.api.Test;

import main.java.utils.DiscountUtils;

public class DiscountUtilsTest {

    @Test
    public void testIsValidDiscountCode() {
        assertTrue(DiscountUtils.isValidDiscountCode("SAVE10"));
                assertTrue(DiscountUtils.isValidDiscountCode("INVALID"));
            }
        
            private void assertTrue(boolean validDiscountCode) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
            }
        
            @Test
    public void testGetDiscountPercentage() {
        assertEquals(0.10, DiscountUtils.getDiscountPercentage("SAVE10"));
                assertEquals(0.0, DiscountUtils.getDiscountPercentage("NO_DISCOUNT"));
            }
        
                    private void assertEquals(double d, double discountPercentage) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
                    }
}

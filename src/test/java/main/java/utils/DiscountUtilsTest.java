package main.java.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountUtilsTest {

    @Test
    public void testIsValidDiscountCode() {
        assertTrue(DiscountUtils.isValidDiscountCode("SAVE10"));
        assertTrue(DiscountUtils.isValidDiscountCode("EMPLOYEE20"));
        assertFalse(DiscountUtils.isValidDiscountCode("INVALIDCODE"));
    }

    @Test
    public void testGetDiscountPercentage() {
        assertEquals(0.10, DiscountUtils.getDiscountPercentage("SAVE10"), 0.01);
        assertEquals(0.20, DiscountUtils.getDiscountPercentage("EMPLOYEE20"), 0.01);
        assertEquals(0.0, DiscountUtils.getDiscountPercentage("INVALIDCODE"), 0.01);
    }
}

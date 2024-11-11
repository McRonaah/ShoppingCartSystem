package main.java.utils;

public class DiscountUtils {
    public static boolean isValidDiscountCode(String discountCode) {
        return "SAVE10".equals(discountCode);
    }

    // Get discount percentage based on code
    public static double getDiscountPercentage(String discountCode) {
        if ("SAVE10".equals(discountCode)) {
            return 0.10; // 10% discount
        }
        return 0.0; // No discount if code is invalid or empty
    }
}

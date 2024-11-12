package main.java.utils;

public class DiscountUtils {
    
    public static boolean isValidDiscountCode(String discountCode) {
        return "SAVE10".equals(discountCode) || "EMPLOYEE20".equals(discountCode);
    }

    // Get discount percentage based on code
    public static double getDiscountPercentage(String discountCode) {
        switch (discountCode) {
            case "SAVE10":
                return 0.10; // 10% discount for Black Friday
            case "EMPLOYEE20":
                return 0.20; // 20% discount for employees
            default:
                return 0.0; // No discount if code is invalid or empty
        }
    }
}


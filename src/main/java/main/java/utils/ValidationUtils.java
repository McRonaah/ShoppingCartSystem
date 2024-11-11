package main.java.utils;

import java.util.regex.Pattern;

import models.Product;

public class ValidationUtils {
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }

    // Check if product ID exists in the given products array
    public static Product findProductById(int productId, Product... products) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Returns null if the product is not found
    }

    // Check if quantity is valid
    public static boolean isQuantityValid(int quantity) {
        return quantity > 0;
    }
}

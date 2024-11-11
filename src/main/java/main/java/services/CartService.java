package main.java.services;

import models.ShoppingCart;
import models.Product;

public class CartService {
    private static final double TAX_RATE = 0.08;

    // Add product to the shopping cart
    public void addProductToCart(ShoppingCart cart, Product product, int quantity) {
        if (!product.isInStock(quantity)) {
            System.out.println("Insufficient stock for " + product.getName());
            return;
        }
        cart.addItem(product, quantity);
        System.out.println(quantity + " x " + product.getName() + " added to cart.");
    }

    // Remove product from the shopping cart
    public void removeProductFromCart(ShoppingCart cart, Product product) {
        cart.removeItem(product);
        System.out.println(product.getName() + " removed from cart.");
    }

    // Apply discount to the total amount
    public double applyDiscount(double totalAmount, String discountCode) {
        double discount = 0.0;
        
        // Simple discount logic (10% off if the code is "SAVE10")
        if ("SAVE10".equals(discountCode)) {
            discount = 0.10;
        }

        double discountedAmount = totalAmount * (1 - discount);
        System.out.printf("Discount applied: %.2f%% off. New Total: $%.2f\n", discount * 100, discountedAmount);
        return discountedAmount;
    }

    // Calculate total amount with tax
    public double calculateTotalWithTax(double amount) {
        return amount * (1 + TAX_RATE);
    }
}

package models;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items = new HashMap<>();
    private double totalAmount = 0.0;
    private static final double TAX_RATE = 0.08;

    // Add item to cart
    public void addItem(Product product, int quantity) {
        if (!product.isInStock(quantity)) {
            System.out.println("Insufficient stock for " + product.getName());
            return;
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
        product.decrementStock(quantity);
        updateTotalAmount();
    }

    // Remove item from cart
    public void removeItem(Product product) {
        if (items.containsKey(product)) {
            int quantity = items.get(product);
            items.remove(product);
            product.incrementStock(quantity);
            updateTotalAmount();
        }
    }

    // Calculate total amount with tax
    public double calculateTotalWithTax() {
        return totalAmount * (1 + TAX_RATE);
    }

    // Get items in the cart
    public Map<Product, Integer> getItems() {
        return items;
    }

    // Calculate total price of items (before tax) — similar to getTotalPrice
    public double getTotalPrice() {
        return totalAmount;
    }

    // Private helper to update total amount
    private void updateTotalAmount() {
        totalAmount = items.entrySet().stream()
                          .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                          .sum();
    }

    @Override
    public String toString() {
        StringBuilder cartDetails = new StringBuilder("Shopping Cart:\n");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            cartDetails.append(entry.getKey().toString())
                       .append(" - Quantity: ").append(entry.getValue())
                       .append("\n");
        }
        cartDetails.append("Total Amount (before tax): $").append(totalAmount);
        return cartDetails.toString();
    }

    // Get total amount (before tax)
    public double getTotalAmount() {
    return totalAmount;
}

}

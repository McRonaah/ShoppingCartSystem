package models;

import java.util.Map;
import java.util.UUID;

public class Order {
     private String orderId;
    private Customer customer;
    private Map<Product, Integer> items;
    private String status;

    // Constructor
    public Order(Customer customer, Map<Product, Integer> items) {
        this.orderId = UUID.randomUUID().toString();
        this.customer = customer;
        this.items = items;
        this.status = "Pending";
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public Map<Product, Integer> getItems() { return items; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    // Generate order confirmation
    public void generateConfirmation() {
        System.out.println("Order Confirmation:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.toString());
        System.out.println("Items:");
        items.forEach((product, quantity) -> 
            System.out.println(product.toString() + " - Quantity: " + quantity)
        );
        System.out.println("Order Status: " + status);
    }
}

package main.java.services;

import models.ShoppingCart;
import models.Customer;
import models.Order;
import models.Product;

import java.util.Map;

public class OrderService {
     public Order createOrder(Customer customer, ShoppingCart cart) {
        Map<Product, Integer> cartItems = cart.getItems();
        
        if (cartItems.isEmpty()) {
            System.out.println("The cart is empty. Cannot create order.");
            return null;
        }

        Order order = new Order(customer, cartItems);
        System.out.println("Order created successfully.");
        return order;
    }

    // Generate order confirmation
    public void generateOrderConfirmation(Order order) {
        if (order != null) {
            order.generateConfirmation();
            System.out.println("Order confirmed. Thank you for your purchase!");
        } else {
            System.out.println("Order could not be processed.");
        }
    }
}

package models;

public class Product {
    private int id;
    private String name;
    private double price;
    private String category;
    private int stockQuantity;

    // Constructor
    public Product(int id, String name, double price, String category, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    // Methods to manage stock
    public boolean isInStock(int quantity) {
        return stockQuantity >= quantity;
    }

    public void decrementStock(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
        }
    }

    public void incrementStock(int quantity) {
        stockQuantity += quantity;
    }

    @Override
    public String toString() {
        return String.format("Product [ID: %d, Name: %s, Price: %.2f, Category: %s, Stock: %d]", 
                              id, name, price, category, stockQuantity);
    }

    public void setPrice(double d) {
        throw new UnsupportedOperationException("Unimplemented method 'setPrice'");
    }
}

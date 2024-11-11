package models;

public class Customer {
    private String name;
    private String email;
    private String address;

    // Constructor
    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public boolean validateEmail() {
        return email != null && email.contains("@") && email.contains(".");
    }

    @Override
    public String toString() {
        return String.format("Customer [Name: %s, Email: %s, Address: %s]", name, email, address);
    }
}

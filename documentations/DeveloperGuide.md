# **Developer Guide for Online Shopping Cart System**

Welcome to the Developer Guide for the **Online Shopping Cart System**. This document provides all the information you need to understand the codebase, set up a development environment, and contribute effectively.

---

## **Table of Contents**
1. [Project Overview](#project-overview)
2. [Setting Up the Development Environment](#setting-up-the-development-environment)
3. [Project Structure](#project-structure)
4. [Coding Standards](#coding-standards)
5. [Core Components](#core-components)
6. [Working with the Codebase](#working-with-the-codebase)
7. [Testing Guidelines](#testing-guidelines)
8. [Version Control and Branching](#version-control-and-branching)
9. [Best Practices](#best-practices)
10. [Contributing](#contributing)

---

## **1. Project Overview**

The **Online Shopping Cart System** is a Java-based application that simulates an online shopping experience. Users can browse products, add items to a cart, apply discounts, and proceed to checkout. This system supports core e-commerce functions, such as:
- Adding/removing items from the cart
- Calculating totals with tax
- Applying discount codes
- Checking stock availability
- Generating order confirmations

---

## **2. Setting Up the Development Environment**

### **Prerequisites**
- **Java JDK** 17 or higher
- **Maven** for dependency management (optional)
- **VS Code** or **IntelliJ IDEA** (recommended IDEs)

### **Setup Instructions**
1. **Clone the repository**:
   <!-- ```bash -->
   >git clone [OnlineShoppingCartSystem](https://github.com/McRonaah/ShoppingCartSystem)

   >cd `OnlineShoppingCartSystem`
2. **Open the project in your IDE:**
    - Open the `OnlineShoppingCartSystem` folder in VS Code or IntelliJ.
3. **Build the project (optional with Maven):**
     ```bash
   mvn clean install
4. **Open the project in your IDE:**
This project follows a clear and modular folder structure:


## **3. Project Structure**
This project follows a clear and modular folder structure:
The overview of the project structure;

     ```bash
    OnlineShoppingCartSystem/
    ├── src/
    │   ├── models/
    │   ├── services/
    │   ├── utils/
    │   ├── tests/
    │   └── Main.java
    ├── README.md
    ├── documentations/
    │   ├── UserManual.md
    │   ├── ProjectReport.md
    │   └── DeveloperGuide.md
      
**Explanation of Key Folders**

- `src/models/`: Contains essential data models like `Product`, `ShoppingCart`, `Customer`, and `Order`.
- `src/services/`: Includes helper classes (`CartService`, `OrderService`) for managing the cart and order operations.
- `src/utils/`: Contains utility classes (`InputValidator`, `DiscountHelper`, `Logger`) for validation, discount management, and logging.
- `src/tests/`: Holds unit tests for major classes to ensure system reliability.

    OnlineShoppingCartSystem Project structure;
    ```bash
    ShoppingCartSystem/
    ├── src/
    │   ├── main/
    │   │   ├── java/
        │   │   │   ├── Main.java
        │   │   │   ├── models/
        │   │   │   │   ├── Customer.java
        │   │   │   │   ├── Order.java
        │   │   │   │   ├── Product.java
        │   │   │   │   ├── ShoppingCart.java
        │   │   │   ├── services/
        │   │   │   │   ├── CartService.java
        │   │   │   │   ├── OrderService.java
        │   │   │   ├── utils/
        │   │   │   │   ├── DiscountUtils.java
        │   │   │   │   ├── LoggerUtils.java
        │   │   │   │   ├── ValidationUtils.java
                |--Main.java
        │   ├── test/
        │   │   ├── java/
        │   │   │   ├── models/
        │   │   │   │   ├── CustomerTest.java
        │   │   │   │   ├── OrderTest.java
        │   │   │   │   ├── ProductTest.java
        │   │   │   │   ├── ShoppingCartTest.java
        │   │   │   ├── services/
        │   │   │   │   ├── CartServiceTest.java
        │   │   │   │   ├── OrderServiceTest.java
        │   │   │   ├── utils/
        │   │   │   │   ├── DiscountUtilsTest.java
        │   │   │   │   ├── LoggerUtilsTest.java
        │   │   │   │   ├── ValidationUtilsTest.java
    ├── pom.xml
## **4. Coding Standards**
**Naming Conventions:**
- Classes: Use `PascalCase` (e.g., `ShoppingCart`, `CartService`).
- Methods: Use `camelCase` (e.g., `calculateTotal`, `isValidDiscountCode`).
- Constants: Use `UPPER_CASE` with underscores (e.g., `TAX_RATE`).

**Code Formatting:**
- Indent your code atleast 4 spaces.
- Place braces on the same line.
- Limit lines of codes to 80 characters for readability.
- Mark code blocks as preformatted text.

## **5. Core Components**
1. **Models:**
    - `Product.java`: Defines the properties of each product (e.g., name, price, stock).
    - `ShoppingCart.java`: Manages items in the cart, including adding and removing products.
    - `Customer.java`: Stores customer details like name and contact information.
    - `Order.java`: Represents a completed order with a list of purchased items and the total amount.
2. **Services:**
    - `CartService.java`: Provides functions to manage cart items, calculate totals, and check stock.
    - `OrderService.java`: Manages order processing, including tax calculation and discount application.

3. **Utils:**
    - `InputValidator.java`: Validates user inputs (e.g., email, product IDs).
    - `DiscountHelper.java`: Manages discount codes and calculates the appropriate discount.
    - `Logger.java`: Logs key actions (e.g., product added, checkout completed) to help with debugging.

## **6. Working with our Codebase**
**Adding New Features:**

1. Create a new branch named after the feature (e.g., `feature/add-wishlist`).
2. Develop and test the feature in this branch.
3. Ensure all code adheres to coding standards and passes all tests.
4. Submit a pull request (PR) with a detailed description of the changes.

**Applying Discounts**

Discounts are managed in `DiscountHelper`.java. Add any new discount codes here, along with their percentage values.

## **7. Testing Guidelines**
**Running Tests**
- Tests are located in `src/tests/`.
- To run all tests, use the following command (if using Maven):
    ```bash
    mvn test
**Writing New Tests**
1. Write unit tests for any new methods or classes.
2. Place new tests in `src/tests/`, ideally naming the test class after the file it’s testing (e.g., `ProductTest.java` for `Product.java`).

**Test Coverage**
- Ensure all core functionalities are covered, especially critical functions like adding items to the cart, calculating totals, and applying discounts.


## **8. Version Control and Branching**
We use Git for version control. Follow these guidelines:

- **Main Branch:** Only stable, production-ready code goes here.
- **Feature Branches:** Develop new features in separate branches named `feature/feature-name`.
- **Bugfix Branches:** Fix bugs in branches named `bugfix/bug-name.`
- **Pull Requests:** Submit PRs to merge changes into the main branch. PRs should include a clear description and reference any related issues.

## **9. Best Practices**

1. Write **Clean, Self-Documenting Code:** Keep methods small and focused on a single task. Use meaningful variable and method names.
2. Comment Complex Code: Briefly explain complex logic or calculations.
3. Optimize for Reusability: Design methods and classes to be as modular and reusable as possible.
4. Test Before Pushing: Ensure all tests pass before pushing changes to the repository.

## **10. Contributing.**
We welcome contributions from the development community! To contribute:
- `Fork` the repository on GitHub.
- `Create a new branch `for your feature or bug fix.
- Make your changes and test them thoroughly.
- Submit a `pull request` with a clear description of the changes and why they’re beneficial.

Thank you for contributing to the Online Shopping Cart System! With your help, we can continue to improve this project and deliver a better online shopping experience.
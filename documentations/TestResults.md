# **TEST RESULTS**
Here are the comprehensive test results for the Shopping Cart System, covering all implemented features:
## **Feature 1: Add Items to Cart**
### Test Case 1: Add a Valid Product to the Cart
<ul>
<li> <b>Action:</b> Enter a valid product ID (e.g., <code>1</code> for "Laptop") and a quantity within available stock.</li>
<li><b>Expected Result:</b> The product is added to the cart, and a confirmation message is displayed.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Enter product ID to add to cart (or 0 to checkout): 1
    Enter quantity: 2
    2 Laptop(s) added to cart.
``` 
### Test Case 2: Add More Than Available Stock
<ul>
<li> <b>Action:</b> Enter a valid product ID but request a quantity exceeding available stock.</li>
<li><b>Expected Result:</b> The system rejects the request and throws an error message.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Enter quantity: 15
    Insufficient stock for this product.
``` 

## **Feature 2: Remove Items from Cart**
### Test Case 1: Remove a Product in Cart
<ul>
<li> <b>Action:</b> Select option<code>7</code> enter the product ID, and remove a valid product from the cart.</li>
<li><b>Expected Result:</b> The product is removed from the cart, and a confirmation message is displayed.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Enter product ID to remove from cart: 1
    Removed Laptop from cart.
``` 
### Test Case 2: Remove a Product Not in Cart
<ul>
<li> <b>Action:</b> Select option <code>7</code> and enter a product ID that is not in the cart.</li>
<li><b>Expected Result:</b> The system notifies the user that the product is not in the cart.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Product not found in the cart.
``` 

## **Feature 3: View Cart Items**
### Test Case 1: View Items in Cart
<ul>
<li> <b>Action:</b> Select option <code>8</code> to view cart items.</li>
<li><b>Expected Result:</b> The system displays all items in the cart with quantities and total cost (before tax).</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Items in your cart:
    Laptop - 2 unit(s) - KES50000.0
    Book - 1 unit(s) - KES245.0
    Total Amount (before tax): KES50245.0
``` 
### Test Case 2: View Empty Cart
<ul>
<li> <b>Action:</b> View cart when no items have been added.</li>
<li><b>Expected Result:</b> The system displays a message that the cart is empty.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Your cart is empty.
``` 
## **Feature 4: Calculate Total with Tax**
### Test Case: Verify Total Calculation
<ul>
<li> <b>Action:</b> Add items to the cart and proceed to checkout.</li>
<li><b>Expected Result:</b> The total cost is displayed, including an 8% tax.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Subtotal: KES50245.0
    Tax (8%): KES4019.6
    Total Amount: KES54264.6
``` 
## **Feature 5: Apply Discount Codes**
### Test Case 1: Apply a Valid Discount Code
<ul>
<li> <b>Action:</b> AEnter a valid discount code (e.g., <code>SAVE10</code>) or <code>EMPLOYEE20</code>.</li>
<li><b>Expected Result:</b> he discount is applied, and the new total is displayed.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Discount applied! New total: KES48838.14
``` 

## **Feature 6: Check Stock Availability**
### Test Case 1: Display Stock Availability
<ul>
<li> <b>Action:</b> Select option <code>9</code> to check stock.</li>
<li><b>Expected Result:</b>  The system displays stock quantities for all products.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Enter your choice: 9
    Current stock availability:
    Laptop: 10 units available
    Phone: 15 units available
    Tablet: 5 units available
    Book: 100 units available
    Pen: 200 units available
``` 
### Test Case 2: Verify Stock After Adding a Product
<ul>
<li> <b>Action:</b> Add a product to the cart, then check stock availability.</li>
<li><b>Expected Result:</b> The stock decreases according to the quantity added.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Pen: 198 units available
``` 

## **Feature 7: Generate Order Confirmation**
### Test Case: Verify Order Confirmation
<ul>
<li> <b>Action:</b> Complete the checkout process.</li>
<li><b>Expected Result:</b> An order confirmation is displayed with order details and the total amount.</li>
<li><b>Example Output:</b></li>
</ul>

```bash
    Order placed successfully!
    Order ID: 30d08252-969d-40a1-95bc-1aa4dc50c212
    Customer: Mishell Mumbua
    Total amount: KES48084.84
``` 
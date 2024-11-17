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


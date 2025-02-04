<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import = "com.tap.model.Cart" %>
    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link rel="stylesheet" href="checkOut.css">
</head>
<body>
    <div class="container">
        
        
        <main>
            <h1>Checkout</h1>
            
            <div class="checkout-form">
                <section class="delivery-address">
                    <h2>Delivery Address</h2>
                    <div class="form-group">
                        <input type="text" placeholder="Full Name" required>
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Street Address" name="street" required>
                    </div>
                    <div class="form-row">
                        <input type="text" placeholder="City" name="city"  required>
                        <input type="text" placeholder="State" name="state" required>
                    </div>
                    <div class="form-row">
                        <input type="text" placeholder="ZIP Code"  name="zip" required>
                        <input type="tel" placeholder="Phone Number" name="phone"  required>
                    </div>
                </section>

                <section class="payment-method">
                    <h2>Payment Method</h2>
                    <div class="payment-options">
                        <label class="radio-label">
                            <input type="radio" name="payment" value="card" id="card" checked>
                            <span>Credit/Debit Card</span>
                        </label>
                        <label class="radio-label">
                            <input type="radio" name="payment" value="upi" id="upi">
                            <span>UPI</span>
                        </label>
                        <label class="radio-label">
                            <input type="radio" name="payment" value="cod" id="cod">
                            <span>Cash on Delivery</span>
                        </label>
                    </div>
                    
                    <div class="card-details">
                        <div class="form-group">
                            <input type="text" placeholder="Card Number" required>
                        </div>
                        <div class="form-row">
                            <input type="text" placeholder="MM/YY" required>
                            <input type="text" placeholder="CVV" required>
                        </div>
                    </div>
                </section>



			<%
                
                Cart cart =(Cart)session.getAttribute("cart");
                
                %>



                <section class="order-summary">
                    <h2>Order Summary</h2>
                    <div class="summary-row">
                        <span>Subtotal</span>
                        <span>₹<%=(double)cart.getTotalPrice() %></span>
                    </div>
                    <div class="summary-row">
                        <span>Delivery Fee</span>
                        <span>₹5.00</span>
                    </div>
                    <div class="summary-row total">
                        <span>Total</span>
                        <span>₹<%=(double)cart.getTotalPrice()+5 %></span>
                    </div>
                </section>
                
                
				
                <form action="conformation.jsp">
                 <label for="deliveryAddress">Delivery Address:</label>
                	<button class="place-order">Place Order</button>
                </form>
                
            </div>
        </main>
    </div>
</body>
</html>
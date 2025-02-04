<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tap.model.Order, com.tap.model.Restaurant" %>
<%@ page import = "com.tap.dao.RestaurantDAO" %>
<%@ page import = "com.tap.daoimplementation.RestaurantDAOImpl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmed</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/confirmation.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    
    <script>
        document.addEventListener("DOMContentLoaded", () => {
            const audio = new Audio("images/Payment_Sound.mp3");
            audio.play();
        });
    </script>
</head>
<body>
    <%
    Order order = (Order) session.getAttribute("order");
    int restaurantId = (Integer) session.getAttribute("restaurantId");
    RestaurantDAO restaurantDao = new RestaurantDAOImpl();
    Restaurant restaurant = restaurantDao.getRestaurant(restaurantId);
    
    String address = "Invalid address";  // Default value
    if (order != null && order.getAddress() != null) {
        String[] addressArr = order.getAddress().split(",");
        if (addressArr.length > 1) {
            address = addressArr[0] + "," + addressArr[addressArr.length - 1];
        }
    }
    %>
    
    <main class="confirmation-container">
        <div class="confirmation-card">
            <div class="success-icon">
                <i class="fas fa-check-circle"></i>
            </div>
            <h1>Order Confirmed!</h1>
            <p class="confirmation-message">Your order has been successfully placed.</p>
            
            <div class="delivery-animation">
                <video class="delivery-video" autoplay loop muted playsinline>
                    <source src="images/video.mp4" type="video/mp4">
                </video>
            </div>
            
            <div class="order-details">
                <h2>Order Details</h2>
                <div class="detail-row">
                    <span>Order Number:</span>
                    <span>#ORD100<%= order != null ? order.getOrderId() : "N/A" %></span>
                </div>
                <div class="detail-row">
                    <span>Estimated Delivery:</span>
                    <span><%= restaurant.getdeliveryTime() %></span>
                </div>
                <div class="detail-row">
                    <span>Delivery Address:</span>
                    <span><%= address %></span>
                </div>
            </div>
        </div>
    </main>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    <%@ page import="java.util.List,com.tap.model.Restaurant" %>

    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tap Foods - Restaurants</title>
    <link rel="stylesheet" href="restaurant1.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar">
        <div class="brand">Tap Foods</div>
        <div class="search-container">
            <input type="text" placeholder="Search for restaurants..." class="search-input">
            <svg class="search-icon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="11" cy="11" r="8"/><path d="m21 21-4.3-4.3"/></svg>
        </div>
        <div class="nav-links">
            <a href="#" class="nav-link">Home</a>
            <a href="#" class="nav-link">Sign Out</a>
            <div class="cart-icon">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="8" cy="21" r="1"/><circle cx="19" cy="21" r="1"/><path d="M2.05 2.05h2l2.66 12.42a2 2 0 0 0 2 1.58h9.78a2 2 0 0 0 1.95-1.57l1.65-7.43H5.12"/></svg>
                <span class="cart-count">0</span>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <header class="hero">
        <h1>Welcome to Tap Foods!</h1>
        <p>Discover the finest restaurants in your area. From local favorites to international cuisine, we bring the best food right to your doorstep.</p>
    </header>

    <!-- Restaurant Cards Container -->
    <main class="restaurant-container">
    
    
    <%
  			  	List<Restaurant> resturants = (List<Restaurant>)request.getAttribute("restaurants");
    			for (Restaurant restaurant : resturants) {
    		
  				 %>
    
    
        <!-- Restaurant Cards -->
        
        
        
        <div class="restaurant-card">

			        
            <div class="restaurant-image" style="background-image: url('<%= restaurant.getImagePath() %>' )"></div>
           
            <div class="restaurant-info">
                <div class="restaurant-header">
                    <h2><%= restaurant.getName() %></h2>
                    <span class="status open"><%= restaurant.getisActive() ? "open" : "closed" %></span>
                </div>
                <p class="cuisine"><%= restaurant.getCusineType() %></p>
                <div class="details">
                    <div class="rating">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="currentColor" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"/></svg>
                        <%= restaurant.getRating() %>
                    </div>
                    <div class="delivery-time">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="10"/><polyline points="12 6 12 12 16 14"/></svg>
                       <%= restaurant.getdeliveryTime() %>  mins
                    </div>
                </div>
                <a href="menu?restaurantId=<%= restaurant.getRestaurantId()%>"> 
                <button class="view-menu">View Menu</button>
                 </a>
            </div>
        </div>

	 <%
    				}
			  %>
    

     
    </main>
</body>
</html>
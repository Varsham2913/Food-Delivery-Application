<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%@ page import="java.util.List,com.tap.model.Menu" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Menu</title>
    <style>
    
    * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: system-ui, -apple-system, sans-serif;
}

body {
  background-color: #f9fafb;
  min-height: 100vh;
}

header {
  background-color: white;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
  padding: 1.5rem;
  text-align: center;
}

h1 {
  font-size: 2rem;
  color: #111827;
  font-weight: bold;
}

main {
  max-width: 1200px;
  width: 90%;
  margin: 2rem auto;
  padding: 0;
}

.menu-container {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  gap: 1.5rem;
  margin: 0 auto;
}

@media (min-width: 1024px) {
  .menu-container {
    grid-template-columns: repeat(4, 1fr);
  }
}

.menu-card {
  background: white;
  border-radius: 0.5rem;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  transition: box-shadow 0.3s ease;
  min-width: 280px;
  
}

.menu-card:hover {
 transform: scale(1.05);
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.menu-image {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.menu-content {
  padding: 1.25rem;
}

.menu-title {
  font-size: 1.25rem;
  font-weight: 600;
  color: #1f2937;
  margin-bottom: 0.5rem;
}

.menu-description {
  font-size: 0.875rem;
  color: #6b7280;
  margin-bottom: 0.75rem;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
}

.menu-info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 0.75rem;
}

.rating {
  display: flex;
  align-items: center;
  gap: 0.25rem;
  color: #6b7280;
  font-size: 0.875rem;
}

.star {
  color: #fbbf24;
  font-size: 1rem;
}

.price {
  font-weight: 600;
  color: #1f2937;
}

.add-to-cart {
  width: 100%;
  background-color: #2563eb;
  color: white;
  border: none;
  border-radius: 0.375rem;
  padding: 0.75rem;
  font-size: 0.875rem;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.add-to-cart:hover {
  background-color: #1d4ed8;
}
    
    
    </style>
</head>
<body>
    <header>
        <h1>Our Menu</h1>
    </header>

    <main>
        <div class="menu-container">
        
        
         <%
        	List<Menu> menuItems = (List<Menu>) request.getAttribute("menus");
        
       		if (menuItems != null && !menuItems.isEmpty()) {

                for (Menu menu : menuItems){
        	
        %>
        
        
        
            <div class="menu-card">
                <img src="<%= menu.getImagePath()%>"  alt="<%= menu.getItemName() %>" class="menu-image">
                <div class="menu-content">
                    <h3 class="menu-title"><%=menu.getItemName() %></h3>
                    <p class="menu-description"><%= menu.getDescription() %></p>
                    <div class="menu-info">
                        <div class="rating">
                            <span class="star">★</span>
                            <span><%= menu.getRatings() %></span>
                        </div>
                        <span class="price">₹<%= menu.getPrice() %></span>
                    </div>
                    
                    <form action="cart" method="post">
	                 <input type="hidden" name="restaurantId" value="<%= menu.getRestaurantId() %>">
	                 <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
	                 <input type="hidden" name="quantity" value="1">
	                 <input type="hidden" name="action" value="add">
	                <button class="add-to-cart">Add to Cart</button>
                 </form> 
                    
                </div>
            </div>

        <%
                } // End of menuItems loop

       	  } else {
 	
        %> 
  			<p> No Menu items available</p>
  			      
        <%
            } // End of menuItems check
        %>


         
        </div>
    </main>
</body>
</html>
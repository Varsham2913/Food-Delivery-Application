<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ page
	import="com.tap.model.CartItem, java.util.Map , java.util.Collection,com.tap.model.Cart"%>
	
	
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Food Cart</title>
   <link rel="stylesheet" href="cart.css">
</head>
<body>
  <div class="container">
    <div class="cart">
      <div class="cart-header">
        <h1 class="cart-title">Food Cart</h1>
        <span class="cart-count">${cart.items.size()} items</span>
      </div>

      <div class="cart-items">
      
      
      <%
			Cart cart =(Cart)session.getAttribute("cart");
			if(cart != null){
				
			 Map<Integer, CartItem> cartItems = cart.getItems();
			  if(!cartItems.isEmpty()){

				Collection<CartItem> items = cartItems.values();

				for (CartItem item :items){
			%>
      
      
      
      
      
        <div class="cart-item">
          <img src="<%=item.getImagePath()%>" alt="<%=item.getName() %>" class="item-image">
          <div class="item-details">
            <h3 class="item-name"><%=item.getName() %></h3>
            <p class="item-price">₹<%= item.getQuantity()*item.getPrice() %></p>
          </div>
          <div class="item-controls">
            <div class="quantity-controls">
            <form action="cart" method="post">
					    <input type="hidden" name="action" value="update">
					    <input type="hidden" name="quantity" value="<%=item.getQuantity() - 1%>">
					    <input type="hidden" name="restaurantId" value="<%=item.getRestaurantId() %>">
					    <input type="hidden" name="menuId" value=<%=item.getMenuId()%>>
              <button class="quantity-btn">−</button>
              </form>
              
              <span class="quantity"><%=item.getQuantity()%></span>
              
              
              <form action="cart" method="post">
					    <input type="hidden" name="action" value="update">
					    <input type="hidden" name="quantity" value="<%=item.getQuantity() + 1%>">
					    <input type="hidden" name="restaurantId" value="<%=item.getRestaurantId() %>">
					    <input type="hidden" name="menuId" value=<%=item.getMenuId()%>>
              
             			 <button class="quantity-btn">+</button>
             			  </form>
             			 
            </div>
            
            
            <form action="cart" method="post">
					    <input type="hidden" name="action" value="remove">
					    <input type="hidden" name="restaurantId" value="<%=item.getRestaurantId() %>">
					    <input type="hidden" name="menuId" value=<%=item.getMenuId()%>>
            
            <button class="remove-btn">
              <svg class="icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <path d="M3 6h18"></path>
                <path d="M19 6v14c0 1-1 2-2 2H7c-1 0-2-1-2-2V6"></path>
                <path d="M8 6V4c0-1 1-2 2-2h4c1 0 2 1 2 2v2"></path>
              </svg>
            </button>
            </form>
            
            
          </div>
        </div>


       
        <%
			}
				
			%>
        
        
      </div>
    </div>

    <div class="summary">
      <div class="summary-header">
        <h2 class="summary-title">Order Summary</h2>
        <span class="total-price">₹<%=(double)cart.getTotalPrice() %></span>
      </div>
      

      <div class="summary-buttons">
      
      <form action="menu"method="post">
					<input type="hidden" name="restaurantId"value="<%=request.getParameter("restaurantId")%>">
      
        <button class="btn btn-secondary">
          <svg class="icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
            <path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"></path>
            <line x1="3" y1="6" x2="21" y2="6"></line>
            <path d="M16 10a4 4 0 0 1-8 0"></path>
          </svg>
          Add More Items
        </button>
        </form>
        
        <form action="checkOut.jsp" method="post">
        <button class="btn btn-primary">
          Proceed to Checkout
          <svg class="icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
            <line x1="5" y1="12" x2="19" y2="12"></line>
            <polyline points="12 5 19 12 12 19"></polyline>
          </svg>
        </button>
        </form>
        
        
      </div>
      
      
    </div>
  </div>
  
  <%
	}
			  
			  else{
				 %>
				 <p class="empty">Your cart is empty !!</p>

			 <% }
			  
			}
		else{
			
	%>

	<p class="empty">Your cart is empty !!</p>

	<%
	}
	%>
  
  
</body>
</html>
package com.tap.Servlet;

import java.io.IOException;

import com.tap.daoimplementation.MenuDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		System.out.print("Cart servlet called");
		String action=req.getParameter("action");
		
		if(action==null) {
			RequestDispatcher rd=req.getRequestDispatcher("cart1.jsp");
			rd.forward(req, resp);
			return;
		}
		
		HttpSession session =req.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		
		Integer userId = (Integer) session.getAttribute("userId");

		System.out.println("Cart in CartServlet: " + cart);
		System.out.println("User ID in CartServlet: " + userId);
					
				
		int newRestaurantId=Integer.parseInt(req.getParameter("restaurantId"));  // id from menu.jsp
		Integer currentRestaurantId =(Integer)session.getAttribute("restaurantId");  //id from session if there is item add in cart before
				
		if(cart==null || newRestaurantId!= currentRestaurantId ) {
		cart=new Cart();
		session.setAttribute("cart", cart); // set the new cart in session
		session.setAttribute("restaurantId", newRestaurantId); // update the restauarnt id in session
		}
				
		
		if(action.equals("add")) {
			addItemToCart(req,cart);
		}
		
		else if(action.equals("update")) {
			updateCartItem(req,cart);
		}
		else if(action.equals("remove")) {
			removeItemFromCart(req,cart);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("cart1.jsp");
		rd.forward(req,resp);
	}
				
		private void addItemToCart(HttpServletRequest req, Cart cart){
			int itemId=Integer.parseInt(req.getParameter("menuId"));
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			
			 MenuDAOImpl menuDAO=new MenuDAOImpl();
			 Menu menuItem=menuDAO.getMenu(itemId);
			 
			 System.out.println("The menu in Cart Servlet" + menuItem);
			 
			 if(menuItem!=null) {
				 CartItem item = new CartItem(
				 menuItem.getMenuId(),
				 menuItem.getRestaurantId(),
				 menuItem.getItemName(),
				 menuItem.getPrice(),
				 quantity,
				 menuItem.getImagePath()
				);
				 
				cart.addItem(item);
				 
			 }		
		
	}
		
		private void updateCartItem(HttpServletRequest req, Cart cart){
			
			int itemId=Integer.parseInt(req.getParameter("menuId"));
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			cart.updateItem(itemId, quantity);

		}
	
		
		private void removeItemFromCart(HttpServletRequest req, Cart cart) {
			int itemId=Integer.parseInt(req.getParameter("menuId"));
			cart.removeItem(itemId);
		}
		
		
		
		
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req,resp);
		}
		
		
	}


package com.tap.Servlet;

import java.io.IOException;

import com.tap.dao.OrderDAO;
import com.tap.dao.OrderItemDAO;
import com.tap.daoimplementation.OrderDAOImpl;
import com.tap.daoimplementation.OrderItemDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderItem;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {

	


	private OrderDAO orderDAOImpl;
	private OrderItemDAO orderItemDAOImpl; 
	@Override
	public void init(){

		orderDAOImpl = new OrderDAOImpl();
		orderItemDAOImpl = new OrderItemDAOImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		System.out.println("Checkout servlet called");
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		Integer userId = (Integer)session.getAttribute("userId");
		

		System.out.println("Cart in CheckOutServlet: " + cart);
		System.out.println("User ID in CheckOutServlet: " + userId);

		if(cart != null && userId != null && !cart.getItems().isEmpty()) {

			int restaurantId = (Integer)session.getAttribute("restaurantId");
			
			String paymentMode = req.getParameter("payment");
			String phone = req.getParameter("phone");
			
			/*
			String address = req.getParameter("street") + ", " ;
                    address=req.getParameter("city") + ", " ;
                    address=req.getParameter("state") + ", " ;
                    address=req.getParameter("zip");
*/
			
			String address = req.getParameter("street") + ", " 
	                + req.getParameter("city") + ", " 
	                + req.getParameter("state") + ", " 
	                + req.getParameter("zip");


			Order order = new Order();
			
	
			
			
			order.setUserId(userId);
			order.setRestaurantId(restaurantId);
			order.setTotalAmount(cart.getTotalPrice());
			order.setPaymentMode(paymentMode);
			order.setPhone(phone);
			order.setAddress(address);
			
			
			//inserting order

			int orderId = orderDAOImpl.addOrder(order);
			order = orderDAOImpl.getOrder(orderId);
			
			//order.setOrderId(order.getOrderId());  // Ensure this generates a valid order ID
			//order.setAddress(req.getParameter("deliveryAddress")); // Retrieve from form

			// Debugging statements
		//	System.out.println("Generated Order ID: " + order.getOrderId());
		//	System.out.println("Delivery Address: " + order.getAddress());
				

			if(orderId != -1) {

				System.out.println("Generated Order ID: " + order.getOrderId());
				System.out.println("Delivery Address: " + order.getAddress());
				
				for(CartItem cartItem : cart.getItems().values()) {

					OrderItem orderItem = new OrderItem();
					orderItem.setOrderId(orderId);
					orderItem.setMenuId(cartItem.getMenuId());
					orderItem.setQuantity(cartItem.getQuantity());
					orderItem.setTotalPrice(cartItem.getQuantity()*cartItem.getPrice());

					//inserting orderitem
					
					// orderItem=new OrderItem(orderItemId, orderId, menuId, quantity, totalPrice);

					orderItemDAOImpl.addOrderItem(orderItem);

				}
				
				//System.out.println("Order ID: " + order.getOrderId());
			//	System.out.println("Order Address: " + order.getAddress());
				
				
				session.setAttribute("orderNumber", order.getOrderId());  // Store order ID
				session.setAttribute("deliveryAddress", order.getAddress());
				session.setAttribute("order", order);
				
				session.removeAttribute("cart");


				RequestDispatcher rd=req.getRequestDispatcher("conformation.jsp");
				rd.forward(req, resp);

				
			}
			else {
	            System.out.println("Error: Order could not be created.");
	            resp.sendRedirect("cart.jsp?error=OrderCreationFailed");
	        }
			




		}
		else {
	        System.out.println("Error: Cart is empty or user ID is null.");
	        resp.sendRedirect("cart1.jsp?error=EmptyCart");
	    }


	}

}

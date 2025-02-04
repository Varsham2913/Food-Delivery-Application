package com.tap.Servlet;

import java.io.IOException;
import java.util.List;

import com.tap.daoimplementation.RestaurantDAOImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/restaurant")
public class HomeServlet  extends HttpServlet{

	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("Home Servlet called");
			
			RestaurantDAOImpl restauarantDao=new RestaurantDAOImpl();
			
			List<Restaurant> allRestaurants =restauarantDao.getAllRestaurants();
			req.setAttribute("restaurants", allRestaurants);
			
			
			for (Restaurant restaurant : allRestaurants) {
				System.out.println(restaurant);
			}
		
			
			RequestDispatcher rd=req.getRequestDispatcher("restaurant1.jsp");
			rd.forward(req, resp);
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req,resp);
		}
	

}





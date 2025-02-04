package com.tap.Servlet;

import java.io.IOException;

import com.tap.daoimplementation.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("fullname");
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		
		UserDAOImpl userDao=new UserDAOImpl();
		User existingUser=userDao.getUserByEmail(email);
		
		try {
			
			if(existingUser!=null) {
				req.setAttribute("error", "User already exists with this email");
				
				req.getRequestDispatcher("signUp.jsp").forward(req, resp);
			}
			else {
				User user = new User(0, name, username, password, email, phone, address, null, null, null);
				userDao.addUser(user);
				req.setAttribute("message", "Registration Sucessfull!!");
				req.getRequestDispatcher("signIn.jsp").forward(req, resp);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

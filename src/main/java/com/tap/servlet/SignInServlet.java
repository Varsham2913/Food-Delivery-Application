package com.tap.Servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import com.tap.daoimplementation.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		 UserDAOImpl userDao=new UserDAOImpl();
		 User user=userDao.getUserByEmail(email);
		 
		 if(user!=null) {
			 
			 if(user.getPassword().equals(password)) {
				 
				 Timestamp now= Timestamp.from(Instant.now());
				 user.setLastLoginDate(now);
				 userDao.updateLastLoginDate(user.getUserId(), now);
				 
				 HttpSession session=req.getSession();
				 session.setAttribute("userId", user.getUserId());
				 
				 RequestDispatcher rd=req.getRequestDispatcher("restaurant");
				 rd.forward(req, resp);
				 
			 }
			 
			 else {
				 req.setAttribute("error","Invalid password");
				 RequestDispatcher rd=req.getRequestDispatcher("signIn.jsp");
				 rd.forward(req, resp);
			 
		 }
		 }
		 else {
			 req.setAttribute("error","User not found");
			 RequestDispatcher rd=req.getRequestDispatcher("signIn.jsp");
			 rd.forward(req, resp);
			 
		 }
		 
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}


}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign In</title>
  <link rel="stylesheet" href="signIn.css">
</head>
<body>
  <div class="container">
    <div class="signin-card">
      <!-- Header -->
      <div class="header">
        <h2>Welcome back</h2>
        <p>Please sign in to your account</p>
      </div>
      
	<h4><%= request.getAttribute("error") != null ? "<p style='color:red;text-align:center ; display: none '>" + request.getAttribute("error") + "</p>" : "" %></h4>
	<h4><%= request.getAttribute("message") != null ? "<p style='color:green;text-align:center'>" + request.getAttribute("message") + "</p>" : "" %></h4>

      <!-- Form -->
      <form class="signin-form" action="signIn" method="post">
        <!-- Email Input -->
        <div class="form-group">
          <label for="email">Email address</label>
          <div class="input-group">
            <svg class="icon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect width="20" height="16" x="2" y="4" rx="2"/><path d="m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7"/></svg>
            <input type="email" id="email" name="email" required placeholder="Enter your email">
          </div>
        </div>

        <!-- Password Input -->
        <div class="form-group">
          <label for="password">Password</label>
          <div class="input-group">
            <svg class="icon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect width="18" height="11" x="3" y="11" rx="2" ry="2"/><path d="M7 11V7a5 5 0 0 1 10 0v4"/></svg>
            <input type="password" id="password" name="password" required placeholder="Enter your password">
          </div>
        </div>

        <!-- Remember me and Forgot password -->
        <div class="form-options">
          <div class="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">
            <label for="remember-me">Remember me</label>
          </div>
          <a href="#" class="forgot-password">Forgot your password?</a>
        </div>

        <!-- Sign in button -->
        <button type="submit" class="signin-button">
          <svg class="lock-icon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect width="18" height="11" x="3" y="11" rx="2" ry="2"/><path d="M7 11V7a5 5 0 0 1 10 0v4"/></svg>
          Sign in
          <svg class="arrow-icon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M5 12h14"/><path d="m12 5 7 7-7 7"/></svg>
        </button>
      </form>

      <!-- Sign up link -->
      <div class="signup-link">
        <p>Don't have an account? <a href="signUp.jsp">Sign up now</a></p>
      </div>
    </div>
  </div>
</body>
</html>
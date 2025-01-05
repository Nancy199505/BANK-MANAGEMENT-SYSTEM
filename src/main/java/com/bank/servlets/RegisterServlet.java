package com.bank.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Temporary in-memory database
    private static Map<String, User> userDatabase = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Registration Page</h1>");
        out.println("<form method='POST' action='RegisterServlet'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Email: <input type='email' name='email'><br>");
        out.println("Password: <input type='password' name='password'><br>");
        out.println("<button type='submit'>Register</button>");
        out.println("</form>");
        response.sendRedirect("Register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        @SuppressWarnings("unused")
		String password = request.getParameter("password");

        // Mock database interaction
        // Ideally, save the user data to a database here
        System.out.println("User Registered: Name=" + username + ", Email=" + email);

        // Respond to client
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Registration Successful</h1>");
        out.println("<p>Welcome, " + username + "! Your account has been created.</p>");
        out.println("<a href='login.html'>Go to Login</a>");
        
        if (username == null || email == null || password == null || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Invalid input. Please fill all fields.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (userDatabase.containsKey(username)) {
            request.setAttribute("errorMessage", "Username already exists. Please choose a different username.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Save user data
        User user = new User(username,email,password); 
        userDatabase.put(username, user);

        // Forward to profile page
        request.setAttribute("username", user.getUsername());
        request.setAttribute("email", user.getEmail());
        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);
    }

    public static Map<String, User> getUserDatabase() {
        return userDatabase;
    }
        
    }

    
    




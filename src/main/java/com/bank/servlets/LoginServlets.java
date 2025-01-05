package com.bank.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/LoginServlet")
public class LoginServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Login Page</h1>");
        out.println("<form method='POST' action='LoginServlet'>");
        out.println("Email: <input type='email' name='email' required><br>");
        out.println("Password: <input type='password' name='password' required><br>");
        out.println("<button type='submit'>Login</button>");
        out.println("</form>");
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve login credentials from form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Mock user validation (replace with database validation in real scenarios)
        String mockEmail = "user@bank.com";
        String mockPassword = "password123";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (mockEmail.equals(email) && mockPassword.equals(password)) {
            // Successful login
            out.println("<h1>Login Successful</h1>");
            out.println("<p>Welcome back, " + email + "!</p>");
            out.println("<a href='profile.html'>Go to Profile</a>");
        }  else {
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

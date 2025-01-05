package com.bank.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve user details from session or database (mock data here for demonstration)
        String username = (String) request.getSession().getAttribute("username");
        String email = (String) request.getSession().getAttribute("email");

        if (username == null || email == null) {
            out.println("<h1>Unauthorized Access</h1>");
            out.println("<p>Please <a href='login.html'>login</a> to view your profile.</p>");
            return;
        }

        // Display user profile
        out.println("<h1>User Profile</h1>");
        out.println("<p><strong>Username:</strong> " + username + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><a href='LogoutServlet'>Logout</a></p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle post requests if necessary
        doGet(request, response);
    }
}

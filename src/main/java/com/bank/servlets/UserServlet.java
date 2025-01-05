package com.bank.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET Requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().write("<h1>Welcome to the User Management Servlet</h1>");
    }

    // Handles POST Requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        @SuppressWarnings("unused")
		String email = request.getParameter("email");
        @SuppressWarnings("unused")
		String password = request.getParameter("password");

        // Process or Store the Data (mock response for now)
        response.setContentType("text/html");
        response.getWriter().write("<h2>Thank you, " + username + "! Registration Successful.</h2>");
    }
}



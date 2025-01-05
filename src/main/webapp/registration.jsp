<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f7f7f7;
        }
        form {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h2>User Registration</h2>

    <!-- Display error or success message if available -->
    <% 
        String message = (String) request.getAttribute("message");
        if (message != null && !message.isEmpty()) {
    %>
        <p style="color: red;"><%= message %></p>
    <% 
        } 
    %>

    <form action="RegisterServlet" method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>"><br>

        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email" required value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>"><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>




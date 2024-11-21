package com.bank.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/bank_management";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    /**
     * Returns a new database connection.
     * 
     * @return Connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver (optional in modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }

        // Establish and return the connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


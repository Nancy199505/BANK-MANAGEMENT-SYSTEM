package com.bank.DAO;

import static org.junit.jupiter.api.Assertions.*;

import com.bank.Model.User;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class UserDAOTest {

    private UserDAO userDAO;
    private JdbcDataSource dataSource;

    @BeforeEach
    void setUp() throws SQLException {
        dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:testdb");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        try (Connection conn = dataSource.getConnection()) {
            String createTableSQL = "CREATE TABLE users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "email VARCHAR(100) NOT NULL UNIQUE," +
                    "password VARCHAR(100) NOT NULL" +
                    ")";
            conn.createStatement().execute(createTableSQL);
        }

        userDAO = new UserDAO(dataSource);
    }

    @Test
    void testSaveUser() {
        User user = new User("Jane Doe", "jane@example.com", "password123");

        boolean result = (boolean) userDAO.saveUser(user);

        assertTrue(result);
    }

    @Test
    void testGetUserByEmail() {
        User user = new User("Jane Doe", "jane@example.com", "password123");
        userDAO.saveUser(user);

        User retrievedUser = userDAO.getUserByEmail("jane@example.com");

        assertNotNull(retrievedUser);
        assertEquals("Jane Doe", retrievedUser.getName());
    }

    @Test
    void testGetUserByEmail_UserNotFound() {
        User retrievedUser = userDAO.getUserByEmail("nonexistent@example.com");

        assertNull(retrievedUser);
    }
}

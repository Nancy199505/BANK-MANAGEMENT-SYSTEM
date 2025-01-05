package com.bank.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.bank.DAO.UserDAO;
import com.bank.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser_Success() {
        User user = new User("John Doe", "john@example.com", "password123");

        when(userDAO.saveUser(user)).thenReturn(true);

        boolean result = userService.registerUser(user);

        assertTrue(result);
        verify(userDAO, times(1)).saveUser(user);
    }

    @Test
    void testRegisterUser_Failure() {
        User user = new User("John Doe", "john@example.com", "password123");

        when(userDAO.saveUser(user)).thenReturn(false);

        boolean result = userService.registerUser(user);

        assertFalse(result);
        verify(userDAO, times(1)).saveUser(user);
    }

    @Test
    void testGetUserByEmail() {
        User user = new User("John Doe", "john@example.com", "password123");

        when(userDAO.getUserByEmail("john@example.com")).thenReturn(user);

        User result = userService.getUserByEmail("john@example.com");

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(userDAO, times(1)).getUserByEmail("john@example.com");
    }
}

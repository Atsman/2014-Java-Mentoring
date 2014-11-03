package com.epam.mentoring.junit.app;

import com.epam.mentoring.junit.app.dao.UserDAO;
import com.epam.mentoring.junit.app.models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by alehatsman on 11/3/14.
 */
public class AppTest {

    private UserDAO userDAO;

    @Before
    public void createMock() {
        userDAO = mock(UserDAO.class);
        when(userDAO.get(anyInt())).thenReturn(new User("username", "password"));
    }

    @Test
    public void test() {
        assertEquals(userDAO.get(anyInt()).getUsername(), "username");
    }

}

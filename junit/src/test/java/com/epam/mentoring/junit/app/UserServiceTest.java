package com.epam.mentoring.junit.app;

import com.epam.mentoring.junit.app.dao.UserDAO;
import com.epam.mentoring.junit.app.models.User;
import com.epam.mentoring.junit.app.services.UserService;
import com.epam.mentoring.junit.app.services.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
/**
 * Created by alehatsman on 11/3/14.
 */
public class UserServiceTest  {

    private UserService userService;

    @Before
    public void createMock() {
        UserDAO userDAO = mock(UserDAO.class);
        when(userDAO.save(any(User.class))).then(new Answer<Object>() {
            @Override
            public Long answer(InvocationOnMock invocationOnMock) throws Throwable {
                User user = (User) invocationOnMock.getArguments()[0];
                user.setId(1l);
                return user.getId();
            }
        });

        when(userDAO.get(anyInt())).then(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Long id = (Long) invocationOnMock.getArguments()[0];
                return new User(id, "username"+id, "password"+id);
            }
        });

        when(userDAO.list(anyInt())).then(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Integer size = (Integer) invocationOnMock.getArguments()[0];
                List<User> users = new ArrayList<User>();
                for(long i = 0; i < size; i ++) {
                    User user = new User(i, "username"+i, "password"+i);
                    users.add(user);
                }
                return users;
            }
        });

        when(userDAO.list()).then(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<User> users = new ArrayList<User>();
                for (long i = 0; i < 20; i++) {
                    User user = new User(i, "username" + i, "password" + i);
                    users.add(user);
                }
                return users;
            }
        });

        when(userDAO.delete(anyLong())).thenReturn(true);

        userService = new UserServiceImpl(userDAO);
    }

    @Test
    public void list() {
        assertEquals(5, userService.list(5).size());
        assertNotEquals(5, userService.list().size());
    }

    @Test
    public void get() {
        User user = userService.get(0);
        assertNotNull(user);
        assertEquals(0, user.getId());
    }

    @Test
    public void save() {
        long id = userService.save(new User("username", "password"));
        assertNotNull(id);
    }

    @Test
    public void delete() {
        assertTrue(userService.delete(1L));
    }

}

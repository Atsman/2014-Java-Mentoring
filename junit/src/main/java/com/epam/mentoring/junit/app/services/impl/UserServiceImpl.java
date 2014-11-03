package com.epam.mentoring.junit.app.services.impl;

import com.epam.mentoring.junit.app.dao.UserDAO;
import com.epam.mentoring.junit.app.models.User;
import com.epam.mentoring.junit.app.services.UserService;

import java.util.List;

/**
 * Created by alehatsman on 11/3/14.
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> list() {
        return userDAO.list();
    }

    @Override
    public List<User> list(int limit) {
        return userDAO.list(limit);
    }

    @Override
    public User get(long id) {
        return userDAO.get(id);
    }

    @Override
    public long save(User user) {
        return userDAO.save(user);
    }

    @Override
    public boolean delete(long id) {
        return userDAO.delete(id);
    }
}

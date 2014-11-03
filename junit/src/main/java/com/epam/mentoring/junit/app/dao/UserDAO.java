package com.epam.mentoring.junit.app.dao;

import com.epam.mentoring.junit.app.models.User;

import java.util.List;

/**
 * Created by alehatsman on 11/3/14.
 */
public interface UserDAO {

    public List<User> list();

    public List<User> list(int limit);

    public User get(long id);

    public long save(User user);

    public void delete(long id);

}

package com.epam.ear.twitter.beans;

import com.epam.ear.twitter.domain.User;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 * Created by alehatsman on 11/23/14.
 */
@Local
public interface UserBeanLocal {

    public void save(User user);

    public void delete(User user);

    public List<User> list();

}

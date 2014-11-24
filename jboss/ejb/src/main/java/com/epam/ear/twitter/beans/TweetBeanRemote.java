package com.epam.ear.twitter.beans;

import com.epam.ear.twitter.domain.Tweet;
import com.epam.ear.twitter.domain.User;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by alehatsman on 11/23/14.
 */
@Remote
public interface TweetBeanRemote {

    public void save(Tweet tweet);

    public void save(String username, String text);

}

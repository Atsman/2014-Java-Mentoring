package com.epam.mentoring.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.epam.mentoring.domain.Tweet;
import com.epam.mentoring.services.TweetService;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TweetServiceImpl implements TweetService{
	
	private long index = 0;
	private List<Tweet> tweets = new ArrayList<Tweet>();
	
	public void save(Tweet tweet) {
		index++;
		tweet.setId(index);
		tweets.add(tweet);
	}
	
	public List<Tweet> list() {
		return tweets;
	}
	
	public void update(Tweet tweet) {
		Tweet old = find(tweet.getId());
		old.setText(tweet.getText());
	}
	
	public Tweet find(long id) {
		for(Tweet tweet : tweets) {
			if(tweet.getId() == id) {
				return tweet;
			}
		}
		return null;
	}

	public void delete(Tweet tweet) {
		tweets.remove(tweet);
	}

}

package com.epam.mentoring.services;

import java.util.List;

import com.epam.mentoring.domain.Tweet;

public interface TweetService {
	
	void save(Tweet tweet);
	
	List<Tweet> list();
	
	void update(Tweet tweet);
	
	Tweet find(long id);
	
	void delete(Tweet tweet);
	
}

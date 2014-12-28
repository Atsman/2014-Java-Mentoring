package com.epam.mentoring.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.epam.mentoring.domain.Tweet;
import com.epam.mentoring.services.TweetService;

@Controller
@RequestMapping("/tweets")
public class TweetController {
	
	private static final Logger LOGGER = Logger.getLogger(TweetController.class);
	private static final String NOT_VALID_TWEET = "notValidTweet";

	@Autowired
	private TweetService tweetService;
	
	@RequestMapping(produces={"application/xml", "application/json"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Tweet> listWithMarshalling() {
		return tweetService.list();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, @RequestHeader(value="User-Agent") String userAgent) {
		LOGGER.info("User agent: " + userAgent);
		LOGGER.info("List size " + tweetService.list().size());
		model.addAttribute("tweets", tweetService.list());
		return "/tweets/index";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model, HttpSession httpSession) {
		model.addAttribute(NOT_VALID_TWEET, httpSession.getAttribute(NOT_VALID_TWEET));
        return "/tweets/create";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@ModelAttribute("tweet") @Valid Tweet tweet, BindingResult result, HttpSession httpSession) {
        if(result.hasErrors()) {
            httpSession.setAttribute(NOT_VALID_TWEET, tweet);

            return "redirect:/tweets/create";
        } else {
            httpSession.removeAttribute(NOT_VALID_TWEET);
        }
		LOGGER.info("save tweet text: " + tweet.getText());
		tweetService.save(tweet);
		return "redirect:/tweets";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String updateForm(Model model, @PathVariable long id) {
		LOGGER.info("get tweet id: " + id);
		Tweet tweet = tweetService.find(id);
		if(tweet == null) {
			return "404";
		}
		model.addAttribute("tweet", tweet);
		return "/tweets/update";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("tweet") Tweet tweet, @PathVariable long id) {
		if(tweetService.find(id) == null) {
			return "404";
		}
		tweetService.update(tweet);
		return "redirect:/tweets";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long id) {
		Tweet tweet = tweetService.find(id);
		if(tweet == null) {
			return "404";
		}
		tweetService.delete(tweet);
		return "redirect:/tweets";
	}
	
}

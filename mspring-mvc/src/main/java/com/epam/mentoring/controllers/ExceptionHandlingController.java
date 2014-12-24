package com.epam.mentoring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlingController {

	private static final Logger LOGGER = Logger.getLogger(TweetController.class);

	@ExceptionHandler(Exception.class)
	public String handleError(HttpServletRequest req, Exception exception) {
		LOGGER.error("Request: " + req.getRequestURL() + " raised " + exception);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return "404";
	}

}

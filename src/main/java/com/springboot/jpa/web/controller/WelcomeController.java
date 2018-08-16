package com.springboot.jpa.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	private final static Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	@GetMapping("/helloworld")
	public String welcomeCTRL()	{
		logger.debug("welcome method Enter");
		return "welcome";
	}
	
	@GetMapping("/")
	public String homeCTRL()	{
		logger.debug("welcome homeCTRL Enter");
		System.out.println("welcome index page");
		return "index";
	}
}

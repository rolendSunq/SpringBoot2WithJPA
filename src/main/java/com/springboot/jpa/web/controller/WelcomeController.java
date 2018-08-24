package com.springboot.jpa.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.jpa.web.repository.QuestionAnswerBoardRepository;

@Controller
public class WelcomeController {
	private final static Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	private QuestionAnswerBoardRepository qbRepository;
	
	@GetMapping("/helloworld")
	public String welcomeCTRL()	{
		logger.debug("welcome method Enter");
		return "welcome";
	}
	
	@GetMapping("/")
	public String homeCTRL(Model model)	{
		logger.debug("welcome homeCTRL Enter");
		model.addAttribute("questions", qbRepository.findAll());
		return "index";
	}
	
}

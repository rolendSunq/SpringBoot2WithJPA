package com.springboot.jpa.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.jpa.web.repository.QuestionAnswerBoard;
import com.springboot.jpa.web.repository.QuestionAnswerBoardRepository;
import com.springboot.jpa.web.repository.User;
import com.springboot.jpa.web.service.SessionService;

@RequestMapping("/questions")
@Controller
public class QuestionController {
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	private QuestionAnswerBoardRepository qabr;
	
	@GetMapping("/form")
	public String qnaFormPage(HttpSession session) {
		logger.debug("qnaFormPage Enter");
		
		if (!sessionService.isLoginSession(session)) {
			return "/users/form";
		}
		
		return "/qna/form";
	}
	
	@PostMapping
	public String createQna(HttpSession session, String title, String contents) {
		System.out.println("createQna Enter");
		
		if (!sessionService.isLoginSession(session)) {
			return "redirect:/users/form";
		}
		
		User sessionUser = sessionService.getObjectFromSession(session);
		QuestionAnswerBoard qab = new QuestionAnswerBoard(title, sessionUser.getUserid(), contents);
		qabr.save(qab);
		
		System.out.println("createQna End");
		
		return "redirect:/";
	}
}

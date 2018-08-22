package com.springboot.jpa.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.jpa.web.repository.User;
import com.springboot.jpa.web.repository.UserRepository;
import com.springboot.jpa.web.service.SessionService;

@RequestMapping("/users/")
@Controller
public class Login_outController {
	private final static Logger logger = LoggerFactory.getLogger(Login_outController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SessionService sessionService;
	
	@GetMapping("login")
	public String loginPageCTRL() {
		logger.info("loginCTRL Enter.");
		return "/user/login";
	}
	
	@PostMapping("login")
	public String loginCTRL(HttpSession session, String userid, String password) throws Exception {
		logger.debug("userid: " + userid + ", password: " + password);
		User user = userRepository.findByUserId(userid);
		
		if (ObjectUtils.isEmpty(user)) {
			return "redirect:/users/login";
		}
		
		if (!password.equals(user.getPassword())) {
			return "redirect:/users/login";
		}
		
		sessionService.createSession(session, user);
		
		return "redirect:/users";
	}
	
	@GetMapping("logout")
	public String logoutCTRL(HttpSession session) throws Exception {
		sessionService.removeSession(session);
		return "redirect:/";
	}
}

package com.springboot.jpa.web.service;

import javax.servlet.http.HttpSession;

import org.springframework.util.ObjectUtils;

import com.springboot.jpa.web.repository.User;

public class HttpSessionService {
	public static final String USER_SESSION_KEY = "sessionUser";
	
	public boolean isLoginUser(HttpSession session) {
		User sessionUser = (User) session.getAttribute(USER_SESSION_KEY);
		
		if (ObjectUtils.isEmpty(sessionUser)) {
			return false;
		}
		
		return true;
	}
	
	public User getUseerFromSession(HttpSession session) {
		
		if (!isLoginUser(session)) {
			return null;
		}
		
		return (User) session.getAttribute(USER_SESSION_KEY);
	}
	
	public void createSession(HttpSession session, User user ) {
		session.setAttribute(USER_SESSION_KEY, user);
	}
}

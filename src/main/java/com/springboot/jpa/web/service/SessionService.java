package com.springboot.jpa.web.service;

import javax.servlet.http.HttpSession;

public interface SessionService {
	public final static String SESSION_KEY = "sessionUser";
	public <T> void createSession(HttpSession session, T t) throws Exception;
	public void removeSession(HttpSession session) throws Exception;
	public boolean isExistanceSession(HttpSession session);
	public String getPathSession(HttpSession session, String path);
}

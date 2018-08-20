package com.springboot.jpa.web.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class SessionServiceImpl implements SessionService {

	@Override
	public <T> void createSession(HttpSession session, T t) throws Exception {
		
		if (!ObjectUtils.isEmpty(session) && ObjectUtils.isEmpty(t)) {
			throw new Exception("session 생성에 문제가 있습니다.");
		}
		
		session.setAttribute(SESSION_KEY, t);
	}

	@Override
	public void removeSession(HttpSession session) throws Exception {
		
		if (ObjectUtils.isEmpty(session)) {
			throw new Exception("session 제거에 문제가 있습니다.");
		}
		
		session.removeAttribute(SESSION_KEY);
	}

	@Override
	public boolean isExistanceSession(HttpSession session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPathSession(HttpSession session, String path) {
		// TODO Auto-generated method stub
		return null;
	}

}

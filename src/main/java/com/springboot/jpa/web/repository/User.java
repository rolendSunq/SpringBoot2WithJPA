package com.springboot.jpa.web.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=20)
	private String userid;
	
	private String email;
	private String username;
	private String password;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void update(User user) {
		userid = user.userid; 
		email = user.email;   
		username = user.username;
		password = user.password;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("User [id=").append(id)
				.append(", userid=").append(userid)
				.append(", email=").append(email)
				.append(", username=").append(username)
				.append(", password=").append(password)
				.append("]").toString();
	}
	
}

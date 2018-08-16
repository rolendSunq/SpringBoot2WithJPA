package com.springboot.jpa.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.jpa.web.repository.User;
import com.springboot.jpa.web.repository.UserRepository;


@RequestMapping("/users")
@Controller
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/form")
	public String form() {
		return "/user/form";
	}
	
	@PostMapping
	public String create(Model model, User user) {
		logger.debug(user.toString());
		System.out.println(user.toString());
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping
	public String getUserList(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
	@RequestMapping(value = "/{id}/form", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userRepository.getOne(id));
		return "/user/updateForm";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, User user) {
		User findUser= userRepository.getOne(id);
		findUser.update(user);
		userRepository.save(findUser);
		return "redirect:/users";
	}
	
}

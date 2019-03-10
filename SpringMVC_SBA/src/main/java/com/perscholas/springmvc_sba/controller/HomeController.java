package com.perscholas.springmvc_sba.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.perscholas.springmvc_sba.models.*;
import com.perscholas.springmvc_sba.dao.*;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String showLogin() {
		return "LoginPage";
	}

	@RequestMapping(value="/loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam String userName, 
							@RequestParam String password,
							HttpSession session,
							Model model) {
		System.out.println("User Name: " + userName);
		System.out.println("Password: " + password);
		User user = new User();
		UserDAO udao = new UserDAO();
		System.out.println(user.getPassword());
		if (user.getPassword().equals(password)) {
			session.setAttribute("currentUser", user);
			return "WelcomePage";
		} else {
			model.addAttribute("errorMessage", "Passwords did not match");
			session.setAttribute("currentUser", null);
			return "LoginPage";
		}
	}
	
	@RequestMapping(value="/showRegisterUser")
	public String showRegisterUser() {
		return "RegisterPage";
	}
	
	@RequestMapping(value="/registerUser", method = RequestMethod.POST)
	public String registerUser(@RequestParam String userName, 
							@RequestParam String password,
							HttpSession session) throws SQLException {
		System.out.println("User Name: " + userName);
		System.out.println("Password: " + password);
		User user = new User(userName, password);
		UserDAO udao = new UserDAO();
	    int userId = udao.registerUser(user);
	    System.out.println(userId);	
		return "LoginPage";
	}
	
	@RequestMapping(value="/showCreatePoem")
	public String showCreatePoem() {
		return "CreatePoem";
	}
	
	@RequestMapping(value="/CreatePoem")
	public String CreatePoem(@RequestParam String author, 
							@RequestParam String title,
							@RequestParam String content,
							HttpSession session) {
		System.out.println("Author: " + author);
		System.out.println("Title: " + title);
		System.out.println("Content: " + content);
		Poem poem = new Poem(title, author, content);
		PoemDAO pdao = new PoemDAO();
		pdao.insertPoem(poem);
		System.out.println(poem);
		return "CreatePoem";
	}
	
	@RequestMapping(value="/PoemByTitle", method = RequestMethod.POST)
	public String PoemByTitle(@RequestParam String title,
							  HttpSession session) {
		System.out.println("Title: " + title);
		PoemDAO pdao = new PoemDAO();
		Poem poem = pdao.getPoemByTitle(title);
		return "UpdatePoem";
	}
	
	@RequestMapping(value="/showUpdatePoem")
	public String showUpdatePoem() {
		return "UpdatePoem";
	}
	
	@RequestMapping(value="/UpdatePoem")
	public String UpdatePoem(@RequestParam String newContent,
							HttpSession session) {
		System.out.println("New Content: " + newContent);
		Poem poem = new Poem(newContent);
		PoemDAO pdao = new PoemDAO();
		pdao.updatePoemText(poem);
		System.out.println(poem);
		return "UpdatePoem";
	}
	
}

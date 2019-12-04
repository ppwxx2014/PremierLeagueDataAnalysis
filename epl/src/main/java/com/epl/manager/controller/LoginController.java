package com.epl.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epl.manager.service.AdminService;
import com.epl.vo.Admin;
import com.epl.vo.LoginForm;

@Controller
public class LoginController {
	@Autowired private AdminService adminService;
	
	
	@GetMapping("/login")
	public String login(HttpSession session) {
		Admin admin = (Admin)session.getAttribute("admin");
		
		if(admin != null) {
			return "redirect:/login";
		}
		return "login"; 
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, LoginForm loginForm) {
	
		Admin admin = adminService.getAdminOne(loginForm);
		
		if(admin == null) {
			return "redirect:/login";
		}
		session.setAttribute("loginState", admin);
		
		return "redirect:/index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}

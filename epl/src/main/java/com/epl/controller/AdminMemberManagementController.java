package com.epl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epl.vo.Admin;

@Controller
public class AdminMemberManagementController {
	
	@GetMapping("/adminMemberList")
	public String adminMemberList(HttpSession session) {
		/*
		 * if (session.getAttribute("loginState") == null) { return "login"; }
		 */
		System.out.println("adminMemberList page move");
		return "adminmember/memberManagement";
	}
}

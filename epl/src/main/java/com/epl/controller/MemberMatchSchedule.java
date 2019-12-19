package com.epl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.epl.vo.Admin;

@Controller
public class MemberMatchSchedule {
	// 경기일정
	@GetMapping("/getMatchList")
	public String getMatchList(HttpSession session, Model model) {
		Admin loginState = (Admin) session.getAttribute("loginState");
		/*
		 * if (session.getAttribute("loginState") == null) { return "login"; }
		 */
		model.addAttribute("loginState", loginState);
		return "member/getMatchList";
	}
}

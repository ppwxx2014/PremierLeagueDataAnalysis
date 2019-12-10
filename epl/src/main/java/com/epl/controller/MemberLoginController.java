package com.epl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.epl.service.interfaces.MemberService;
import com.epl.vo.Member;

@Controller
public class MemberLoginController {
	@Autowired private MemberService memberService;
	
	@GetMapping("/memberLogin")
	public String memberLogin(HttpSession session) {
		return "member/memberLogin";
	}
	
	@GetMapping("/member/callback")
	public String callback() {
		return "member/callback";
	}
	
	@GetMapping("/memberLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/index";
	}
	
}






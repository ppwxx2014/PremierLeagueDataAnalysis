package com.epl.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epl.service.interfaces.MemberplayerService;



@Controller
public class MemberPlayerController {
	@Autowired MemberplayerService MemberplayerService;
	
	@GetMapping("/getMemberPlayerList")
	public String getUserPlayerList(){
		
		return "member/getMemberPlayerList"; 
	}
	@GetMapping("/getMemberPlayerOne")
	public String getUserPlayerOne(@RequestParam(value = "playerNo", required = true)int playerNo, HttpSession session) {
		session.setAttribute("playerNo", playerNo);
		return "member/getMemberPlayerOne";
	}
}

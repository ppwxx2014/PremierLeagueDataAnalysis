package com.epl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberBoardController {
	
	// 유저 게시판
	@GetMapping("/memberBoard")
	public String memberBoard() {
		return "member/memberBoard";
	}
	
	 
}

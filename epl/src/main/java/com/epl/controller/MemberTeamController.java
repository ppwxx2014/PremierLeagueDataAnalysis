package com.epl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epl.service.interfaces.MemberTeamService;
@Controller
public class MemberTeamController {
	
	@Autowired private MemberTeamService memberTeamService;

		@GetMapping("/getMemberTeamList")
		public String memberteamList(){
			return "member/getMemberTeamList";
		}
		
		@GetMapping("/getMemberTeamOne")
		public String getMemberTeamOne(@RequestParam(value = "teamName" , required = true) String teamName, HttpSession session){
			session.setAttribute("teamName", teamName);
			System.out.println("getMemberTeamOne 폼 요청 param :"+teamName);
			return "member/getMemberTeamOne";	
		}
		
	}



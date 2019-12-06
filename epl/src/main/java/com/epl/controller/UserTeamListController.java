package com.epl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.epl.service.interfaces.UserTeamService;

@Controller
public class UserTeamListController {
	
	@Autowired private UserTeamService userTeamService;

		@GetMapping("/getUserTeamList")
		public String UserteamList(){
			return "getUserTeamList";
		}
		
		@GetMapping("/getUserTeamOne")
		public String getUserTeamOne() {
			return "getUserTeamOne";	
		}
	}



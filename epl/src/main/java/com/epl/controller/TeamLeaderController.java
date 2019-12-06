package com.epl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epl.service.interfaces.TeamLeaderService;
import com.epl.vo.TeamLeader;

@Controller
public class TeamLeaderController {
	@Autowired
	private TeamLeaderService teamLeaderService;

	@GetMapping("/addTeamLeader")
	public String addTeamLeader(TeamLeader teamLeader, Model model) {

		model.addAttribute("teamLeader", teamLeader);

		return "club/addTeamLeader";
	}


}

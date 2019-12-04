package com.epl.teamleader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epl.teamleader.service.TeamLeaderServiceImpl;
import com.epl.vo.TeamLeader;

@Controller
public class TeamLeaderController {
	@Autowired private TeamLeaderServiceImpl teamLeaderService;
	@GetMapping("/addTeamLeader")
	public String addTeamLeader(TeamLeader teamLeader,Model model) {
		
		model.addAttribute("teamLeader",teamLeader);
		
		return "club/addTeamLeader";
	}
	@PostMapping("/club/addTeamLeader")
	public String addTeamLeader(TeamLeader teamLeader) {
		teamLeaderService.addTeamLeader(teamLeader);
		return "redirect:/addTeamLeader";
	}
}

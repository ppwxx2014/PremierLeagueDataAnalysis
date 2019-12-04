package com.epl.teamleader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.teamleader.service.TeamLeaderServiceImpl;
import com.epl.vo.Player;
import com.epl.vo.PlayerContract;


@RestController
public class TeamLeaderRestController {
	@Autowired private TeamLeaderServiceImpl teamLeaderService;
	
	@PostMapping("/getPlayerContract")
	public List<PlayerContract> getPlayerContractList(@RequestParam(value="teamName")String teamName){
		
		List<PlayerContract> list = teamLeaderService.getPlayerContractList(teamName);
		System.out.println("playerContract:" +list);
		System.out.println("conTeamName:"+teamName);
		return list;
	}
}

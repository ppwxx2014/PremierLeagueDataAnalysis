package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.TeamLeaderService;
import com.epl.vo.PlayerContract;

@RestController
public class TeamLeaderRestController {
	@Autowired
	private TeamLeaderService teamLeaderService;

	@PostMapping("/getPlayerContract")
	public List<PlayerContract> getPlayerContractList(@RequestParam(value = "teamName") String teamName) {

		List<PlayerContract> list = teamLeaderService.getPlayerContractList(teamName);
		System.out.println("playerContract:" + list);
		System.out.println("conTeamName:" + teamName);
		return list;
	}
}

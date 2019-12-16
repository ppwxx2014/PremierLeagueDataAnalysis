package com.epl.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.TeamService;
import com.epl.vo.Stadium;
import com.epl.vo.Team;
import com.epl.vo.UpdateTeam;

@RestController
public class TeamRestController {
	@Autowired
	private TeamService teamService;

	@PostMapping("/getStadiumList")
	public List<Stadium> getStadiumList() {
		List<Stadium> list = teamService.getStadiumList();
		return list;
	}

	@PostMapping("/getTeamList")
	public List<Team> getTeamList() {
		List<Team> list = teamService.getTeamList();
		System.out.println("list:" + list);
		return list;
	}
	@PostMapping("/getDownTeamList")
	public List<Team> getDownTeamList(){
		List<Team> list = teamService.getDownTeamList();
		System.out.println("conlist:"+list);
		return list; 
	}
	@PostMapping("/addTeam")
	public int addTeam(Team team, HttpSession session) {
		int row = teamService.addTeam(team);
		return row;
	}
	
	@PostMapping("/leagueDown")
	public int leagueDown(UpdateTeam updateTeam) {
		int row = teamService.leagueDown(updateTeam);
		System.out.println("conRow:"+row);
		return row;
	}
	
	@PostMapping("/leagueUp")
	public int leagueUp(UpdateTeam updateTeam) {
		int row = teamService.leagueUp(updateTeam);
		System.out.println("conRow:"+row);
		return row;
	}

}

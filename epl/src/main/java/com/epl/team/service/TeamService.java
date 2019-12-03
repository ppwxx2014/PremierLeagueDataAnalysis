package com.epl.team.service;

import java.util.List;

import com.epl.vo.Stadium;
import com.epl.vo.Team;




public interface TeamService {

	public int addTeam(Team team);
	
	public List<Stadium> getStadiumList();
	
	public List<Team> getTeamList();
	
	public int removeTeam(Team team);
}

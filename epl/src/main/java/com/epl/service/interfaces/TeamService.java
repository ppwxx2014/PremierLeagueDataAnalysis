package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.Stadium;
import com.epl.vo.Team;
import com.epl.vo.UpdateTeam;

public interface TeamService {
	public int addTeam(Team team);

	public List<Stadium> getStadiumList();

	public List<Team> getTeamList();
	
	public List<Team> getDownTeamList();
	/*
	 * public int removeTeam(Team team);
	 * 
	 * int modifyTeam(Team team);
	 */
	
	public int leagueDown(UpdateTeam updateTeam);
	
	public int leagueUp(UpdateTeam updateTeam);

}

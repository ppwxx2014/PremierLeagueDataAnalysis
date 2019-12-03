package com.epl.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.team.mapper.TeamMapper;
import com.epl.vo.Stadium;
import com.epl.vo.Team;



@Service
@Transactional
public class TeamServiceImpl {
	@Autowired private TeamMapper teamMapper;
	
	public int addTeam(Team team) {
	
		return teamMapper.insertTeam(team);
	}
	public List<Stadium> getStadiumList(){
		
		return teamMapper.selectStadiumList();
	}
	public List<Team> getTeamList(){
		
		return teamMapper.selectTeamList();
	}
	public int removeTeam(Team team) {
		
		return teamMapper.deleteTeam(team);
	}
	public int modifyTeam(Team team) {
		
		return teamMapper.updateTeam(team);
	}
}

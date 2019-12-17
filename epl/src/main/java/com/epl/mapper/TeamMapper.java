package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.ModifyTeam;
import com.epl.vo.Stadium;
import com.epl.vo.Team;
import com.epl.vo.UpdateTeam;

@Mapper
public interface TeamMapper {
	public int insertTeam(Team team);

	public List<Stadium> selectStadiumList();

	/*
	 * int deleteTeam(Team team);
	 * 
	 * public int updateTeam(Team team);
	 */
	public List<Team> selectTeamList();
	
	public List<Team> selectDownTeamList();
	
	public int leagueDown(UpdateTeam updateTeam);
	
	public int leagueUp(UpdateTeam updateTeam);
	
	public int updateTeam(ModifyTeam modifyTeam);
	
}

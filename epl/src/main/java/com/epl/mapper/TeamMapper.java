package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Stadium;
import com.epl.vo.Team;

@Mapper
public interface TeamMapper {
	int insertTeam(Team team);

	public List<Stadium> selectStadiumList();

	int deleteTeam(Team team);

	public List<Team> selectTeamList();

	public int updateTeam(Team team);
}

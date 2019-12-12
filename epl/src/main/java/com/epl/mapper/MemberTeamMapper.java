package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Player;
import com.epl.vo.Team;

@Mapper
public interface MemberTeamMapper {
	public List<Team> selectMemberTeamList();
	public List<Team> selectMemberTeamOne(String teamName);
	public List<Player> selectMemberPlayersList(String players);
	
}

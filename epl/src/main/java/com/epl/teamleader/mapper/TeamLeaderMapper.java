package com.epl.teamleader.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.PlayerContract;
import com.epl.vo.TeamLeader;



@Mapper
public interface TeamLeaderMapper {
	public int insertTeamLeader(TeamLeader teamLeader);
	
	public List<PlayerContract> selectPlayerContractList(String teamName);
}

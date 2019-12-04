package com.epl.teamleader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.teamleader.mapper.TeamLeaderMapper;
import com.epl.vo.PlayerContract;
import com.epl.vo.TeamLeader;


@Service
@Transactional
public class TeamLeaderServiceImpl {
	@Autowired private TeamLeaderMapper teamLeaderMapper;
	public int addTeamLeader(TeamLeader teamLeader) {
		
		return teamLeaderMapper.insertTeamLeader(teamLeader);
	}

	public List<PlayerContract> getPlayerContractList(String teamName){
		List<PlayerContract> row = teamLeaderMapper.selectPlayerContractList(teamName);
		System.out.println("row:"+row);
		System.out.println("serTeamName:"+teamName);
		return row;
		
	}
}

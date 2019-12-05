package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.TeamLeaderMapper;
import com.epl.service.interfaces.TeamLeaderService;
import com.epl.vo.PlayerContract;
import com.epl.vo.TeamLeader;

@Service
@Transactional
public class TeamLeaderServiceImpl implements TeamLeaderService {
	@Autowired
	private TeamLeaderMapper teamLeaderMapper;
	
	@Override
	public int addTeamLeader(TeamLeader teamLeader) {

		return teamLeaderMapper.insertTeamLeader(teamLeader);
	}
	@Override
	public List<PlayerContract> getPlayerContractList(String teamName) {
		List<PlayerContract> row = teamLeaderMapper.selectPlayerContractList(teamName);
		System.out.println("row:" + row);
		System.out.println("serTeamName:" + teamName);
		return row;

	}
}

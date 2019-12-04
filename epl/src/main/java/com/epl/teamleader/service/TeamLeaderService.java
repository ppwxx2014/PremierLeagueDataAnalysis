package com.epl.teamleader.service;

import java.util.List;


import com.epl.vo.PlayerContract;
import com.epl.vo.TeamLeader;



public interface TeamLeaderService {
	public int addTeamLeader(TeamLeader teamLeader);
	
	
	public List<PlayerContract> getPlayerContractList(String teamName);
}

package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.PlayerContract;
import com.epl.vo.TeamLeader;

public interface TeamLeaderService {
	public int addTeamLeader(TeamLeader teamLeader);

	public List<PlayerContract> getPlayerContractList(String teamName);
}

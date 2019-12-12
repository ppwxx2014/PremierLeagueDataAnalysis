package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.Player;
import com.epl.vo.Team;

public interface MemberTeamService {
	public List<Team> selectMemberTeam();
	public List<Team> selectMemberOne(String teamName);
	public List<Player> selectMemberPlayerList(String players);

}

package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.MatchPlayerNo;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Player;
import com.epl.vo.PlayerInfo;
import com.epl.vo.Refree;
import com.epl.vo.Team;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

public interface MatchService {
	public List<Team> getTeamList();

	public List<Refree> getRefreeList();

	public String getStadiumByTeamName(String teamName);

	public int addMatch(MatchSchedule matchSchedule);

	public int addMatchRefree(MatchRefree matchRefree);

	public List<MatchSchedule> getMatchList();

	public MatchSchedule getMatchOne(int matchNo);

	public List<PlayerInfo> getPlayerListByTeamName(String teamName);
	
	public int addMainPlayer(MatchPlayerNo MatchPlayerNo);
	
	public int addSubPlayer(MatchPlayerNo MatchPlayerNo);
	
	public int addKeeper(MatchPlayerNo MatchPlayerNo);
}

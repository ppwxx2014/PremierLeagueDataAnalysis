package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.InGamePosition;
import com.epl.vo.MatchCheckKeeper;
import com.epl.vo.MatchGoalKeeper;
import com.epl.vo.MatchGoals;
import com.epl.vo.MatchNoTeamName;
import com.epl.vo.MatchOwnGoals;
import com.epl.vo.MatchPlayer;
import com.epl.vo.MatchPlayerNo;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchResult;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Player;
import com.epl.vo.PlayerInfo;
import com.epl.vo.Refree;
import com.epl.vo.Team;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

public interface MatchService {

	public String getStadiumByTeamName(String teamName);

	public int addMatch(MatchSchedule matchSchedule);

	public int addMatchRefree(MatchRefree matchRefree);

	public List<MatchSchedule> getMatchList();

	public MatchSchedule getMatchOne(int matchNo);

	public int addMainPlayer(MatchPlayerNo MatchPlayerNo);
	
	public int addSubPlayer(MatchPlayerNo MatchPlayerNo);
	
	public int addKeeper(MatchPlayerNo MatchPlayerNo);
	
	public MatchCheckKeeper checkKeeper(MatchCheckKeeper matchCheckKeeper);
	
	public MatchPlayer getMatchPlayerOne(MatchPlayer matchPlayer);
	
	public MatchGoalKeeper getMatchGoalKeeperOne(MatchGoalKeeper matchGoalKeeper);
	
	public int modifyMatchPlayer(MatchPlayer matchPlayer);
	
	public int addMatchGoals(MatchGoals matchGoals);
	public int addMatchOwnGoals(MatchOwnGoals matchOwnGoals);
	
	public int addMatchResult(MatchResult matchResult);
	
	public int modifyMatchResultByGoal(MatchGoals matchGoals);
	public int modifyMatchResultByOwnGoal(MatchOwnGoals matchOwnGoals);
	
	public int modifyMatchKeeper(MatchGoalKeeper matchGoalKeeper);
	
	public List<PlayerInfo> getPlayerListByTeamName(String teamName);
	
	public List<InGamePosition> getInGamePosition(MatchNoTeamName matchNoTeamName);
}

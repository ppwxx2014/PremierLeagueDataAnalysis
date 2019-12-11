package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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

@Mapper
public interface MatchMapper {
	public String selectStadiumByTeamName(String teamName);

	public int insertMatch(MatchSchedule matchSchedule);

	public int insertMatchRefree(MatchRefree matchRefree);

	public List<MatchSchedule> selectMatchList();

	public MatchSchedule selectMatchOne(int matchNo);
	
	public int insertMainPlayer(MatchPlayerNo MatchPlayerNo);
	
	public int insertSubPlayer(MatchPlayerNo MatchPlayerNo);
	
	public int insertKeeper(MatchPlayerNo MatchPlayerNo);
	
	public MatchCheckKeeper selectKeeperInMatch(MatchCheckKeeper  matchCheckKeeper);
	
	public MatchPlayer selectmatchPlayerOne(MatchPlayer matchPlayer);
	
	public MatchGoalKeeper selectMatchGoalKeeperOne(MatchGoalKeeper matchGoalKeeper);
	
	public int updateMatchPlayer(MatchPlayer matchPlayer);
	
	public int insertMatchGoals(MatchGoals matchGoals);
	public int insertMatchOwnGoals(MatchOwnGoals matchOwnGoals);
	
	public int insertMatchResult(MatchResult matchResult);
	
	public int updateMatchResultByGoal(MatchGoals matchGoals);
	public int updateMatchResultByOwnGoal(MatchOwnGoals matchOwnGoals);
	
	public int updateMatchKeeper(MatchGoalKeeper matchGoalKeeper);
	
	public List<InGamePosition> selectInGamePosition(MatchNoTeamName matchNoTeamName);
	
	public List<PlayerInfo> selectPlayerListByTeamName(String teamName);
}

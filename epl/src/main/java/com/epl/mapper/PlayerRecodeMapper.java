package com.epl.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MatchGoalKeeper;
import com.epl.vo.MatchGoals;
import com.epl.vo.MatchOwnGoals;
import com.epl.vo.MatchPlayer;
import com.epl.vo.Player;


@Mapper
public interface PlayerRecodeMapper {
	public MatchPlayer selectMemberPlayerRecode(int playerNo);
	
	public MatchGoals selectMemberPlayerGoals(int playerNo);
	
	public MatchOwnGoals selectMemberPlayerOwnGoals(int playerNo);
	
	public MatchGoalKeeper selectMemberGoalKeeperRecode(int playerNo);
	
	//getMemberPlayerOne에 속한 결과값이라 불필요.
	//public Player selectMemberPlayerName(int playerNo);
}

package com.epl.service.interfaces;


import com.epl.vo.MatchGoalKeeper;
import com.epl.vo.MatchGoals;
import com.epl.vo.MatchOwnGoals;
import com.epl.vo.MatchPlayer;
import com.epl.vo.Player;


public interface PlayerRecodeService {

	public MatchPlayer getMemberPlayerRecode(int playerNo);
	
	public MatchGoals getMemberPlayerGoals(int playerNo);
	
	public MatchOwnGoals getMemberPlayerOwnGoals(int playerNo);
	
	public MatchGoalKeeper getMemberGoalKeeperRecode(int playerNo);
	
	//getMemberPlayerOne에 속한 결과값이라 불필요.
	//public Player getMemberPlayerName(int playerNo);
}

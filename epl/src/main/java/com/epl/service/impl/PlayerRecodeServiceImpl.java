package com.epl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.PlayerRecodeMapper;
import com.epl.service.interfaces.PlayerRecodeService;
import com.epl.vo.MatchGoalKeeper;
import com.epl.vo.MatchGoals;
import com.epl.vo.MatchOwnGoals;
import com.epl.vo.MatchPlayer;
import com.epl.vo.Player;


@Service
@Transactional
public class PlayerRecodeServiceImpl implements PlayerRecodeService {
	@Autowired PlayerRecodeMapper playerRecodeMapper;
	
	@Override
	public MatchPlayer getMemberPlayerRecode(int playerNo) {
		MatchPlayer matchPlayer = playerRecodeMapper.selectMemberPlayerRecode(playerNo);
		System.out.println("matchPlayer:"+matchPlayer);
		return matchPlayer;
	}
	@Override
	public MatchGoals getMemberPlayerGoals(int playerNo) {
		MatchGoals matchGoals = playerRecodeMapper.selectMemberPlayerGoals(playerNo);
		System.out.println("matchGoals:"+matchGoals);
		return matchGoals;
	}
	@Override
	public MatchOwnGoals getMemberPlayerOwnGoals(int playerNo) {
		MatchOwnGoals matchOwnGoals = playerRecodeMapper.selectMemberPlayerOwnGoals(playerNo);
		System.out.println("MatchOwnGoals:"+matchOwnGoals);
		return matchOwnGoals;
	}
	@Override
	public MatchGoalKeeper getMemberGoalKeeperRecode(int playerNo) {
		MatchGoalKeeper matchGoalKeeper = playerRecodeMapper.selectMemberGoalKeeperRecode(playerNo);
		System.out.println(matchGoalKeeper);
		return matchGoalKeeper;
	}
	//getMemberPlayerOne에 속한 결과값이라 불필요.
	/*@Override
	public Player getMemberPlayerName(int playerNo) {
		Player player = playerRecodeMapper.selectMemberPlayerName(playerNo);
		System.out.println("Player:"+player);
		return player;
	}*/
}

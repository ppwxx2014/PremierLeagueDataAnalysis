package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.MatchMapper;
import com.epl.service.interfaces.MatchService;
import com.epl.vo.MatchPlayerNo;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchSchedule;
import com.epl.vo.PlayerInfo;
import com.epl.vo.Refree;
import com.epl.vo.Team;

@Service
@Transactional
public class MatchListServiceImpl implements MatchService {
	@Autowired
	private MatchMapper matchMapper;
	
	@Override
	public String getStadiumByTeamName(String teamName) {
		String stadium = matchMapper.selectStadiumByTeamName(teamName);
		return stadium;
	}

	@Override
	public int addMatch(MatchSchedule matchSchedule) {
		int check = matchMapper.insertMatch(matchSchedule);
		System.out.println("Match schedule 입력 성공? : " + check);
		int matchNo = matchSchedule.getMatchNo();
		return matchNo;
	}

	@Override
	public int addMatchRefree(MatchRefree matchRefree) {
		int check = matchMapper.insertMatchRefree(matchRefree);
		return check;
	}

	@Override
	public List<MatchSchedule> getMatchList() {
		List<MatchSchedule> list = matchMapper.selectMatchList();
		return list;
	}

	@Override
	public MatchSchedule getMatchOne(int matchNo) {
		MatchSchedule matchSchedule = matchMapper.selectMatchOne(matchNo);
		return matchSchedule;
	}

	@Override
	public List<PlayerInfo> getPlayerListByTeamName(String teamName) {
		List<PlayerInfo> list = matchMapper.selectPlayerListByTeamName(teamName);
		return list;
	}
	
	@Override
	public int addMainPlayer(MatchPlayerNo MatchPlayerNo)
	{
		int check = matchMapper.insertMainPlayer(MatchPlayerNo);
		return check;
	}
	
	@Override
	public int addSubPlayer(MatchPlayerNo MatchPlayerNo)
	{
		int check = matchMapper.insertSubPlayer(MatchPlayerNo);
		return check;
	}
	
	@Override
	public int addKeeper(MatchPlayerNo MatchPlayerNo)
	{
		int check = matchMapper.insertKeeper(MatchPlayerNo);
		return check;
	}
}

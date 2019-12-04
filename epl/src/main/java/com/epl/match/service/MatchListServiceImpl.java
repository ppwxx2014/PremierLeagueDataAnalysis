package com.epl.match.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.match.mapper.MatchMapper;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Player;
import com.epl.vo.PlayerInfo;
import com.epl.vo.Refree;
import com.epl.vo.Team;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

@Service
@Transactional
public class MatchListServiceImpl implements MatchService
{
	@Autowired private MatchMapper matchMapper;
	
	public List<Team> teamList()
	{
		List<Team> homeTeamList = matchMapper.selectTeamList();
		return homeTeamList;
	}
	
	public List<Refree> refreeList()
	{
		List<Refree> refreeList = matchMapper.selectRefreeList();
		return refreeList;
	}
	
	public String selectStadiumByTeamName(String teamName)
	{
		String stadium = matchMapper.selectStadiumByTeamName(teamName);
		return stadium;
	}
	
	public int insertMatch(MatchSchedule matchSchedule)
	{
		int check = matchMapper.insertMatch(matchSchedule);
		System.out.println("Match schedule 입력 성공? : " + check);
		int matchNo = matchSchedule.getMatchNo();
		return matchNo;
	}
	
	public int insertMatchRefree(MatchRefree matchRefree)
	{
		int check = matchMapper.insertMatchRefree(matchRefree);
		return check;
	}
	
	public List<MatchSchedule> selectMatchList()
	{
		List<MatchSchedule> list = matchMapper.selectMatchList();
		return list;
	}
	
	public MatchSchedule selectMatchOne(int matchNo) 
	{
		MatchSchedule matchSchedule = matchMapper.selectMatchOne(matchNo);
		return matchSchedule;
	}
	
	public List<PlayerInfo> selectPlayerListByTeamName(String teamName)
	{
		List<PlayerInfo> list	 = matchMapper.selectPlayerListByTeamName(teamName);
		return list;
	}
}

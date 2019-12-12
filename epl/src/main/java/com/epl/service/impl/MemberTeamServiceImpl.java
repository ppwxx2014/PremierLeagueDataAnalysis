package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.MemberTeamMapper;
import com.epl.service.interfaces.MemberTeamService;
import com.epl.vo.Player;
import com.epl.vo.Team;

@Service
@Transactional
public class MemberTeamServiceImpl implements MemberTeamService{
@Autowired private MemberTeamMapper memberTeamMapper;
	  
	@Override
	public List<Team> selectMemberTeam() {
	List<Team> list = memberTeamMapper.selectMemberTeamList();
	
	System.out.println(list); 
	return list;
	}
	
	@Override
	public List<Team> selectMemberOne(String teamName) {
		List<Team> list = memberTeamMapper.selectMemberTeamOne(teamName);
		System.out.println("MemberService::::::::::::::::::::::::::" + list);
		return list;
	}
	
	@Override
	public List<Player> selectMemberPlayerList(String players){
		List<Player> list = memberTeamMapper.selectMemberPlayersList(players);
		System.out.println("PlayerService::::::::::::::::::::::::::" + list);
		return list;
	}
	
	
}

package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.UserTeamMapper;
import com.epl.service.interfaces.UserTeamService;
import com.epl.vo.Team;

@Service
@Transactional
public class UserTeamServiceImpl implements UserTeamService{
@Autowired private UserTeamMapper userTeamMapper;
	
	@Override
	public List<Team> selectUserTeam() {
	List<Team> list = userTeamMapper.selectUserTeamList();
	
	System.out.println(list); 
	return list;
	}
	
}

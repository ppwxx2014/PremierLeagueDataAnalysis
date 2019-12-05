package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.TeamMapper;
import com.epl.service.interfaces.TeamService;
import com.epl.vo.Stadium;
import com.epl.vo.Team;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamMapper teamMapper;

	@Override
	public int addTeam(Team team) {

		return teamMapper.insertTeam(team);
	}

	@Override
	public List<Stadium> getStadiumList() {

		return teamMapper.selectStadiumList();
	}

	@Override
	public List<Team> getTeamList() {

		return teamMapper.selectTeamList();
	}

	@Override
	public int removeTeam(Team team) {

		return teamMapper.deleteTeam(team);
	}

	@Override
	public int modifyTeam(Team team) {

		return teamMapper.updateTeam(team);
	}
}

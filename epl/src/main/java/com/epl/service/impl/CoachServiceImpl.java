package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.CoachMapper;
import com.epl.service.interfaces.CoachService;
import com.epl.vo.Coach;
import com.epl.vo.Country;

@Service
@Transactional
public class CoachServiceImpl implements CoachService {
	@Autowired
	private CoachMapper coachMapper;
	
	@Override
	public int addCoach(Coach coach) {

		return coachMapper.insertCoach(coach);
	}
	
	@Override
	public List<Country> getCountry() {

		return coachMapper.selectCountry();
	}

	@Override
	public List<Coach> getCoachList() {

		return coachMapper.selectCoachList();
	}
	@Override
	public int modifyCoach(Coach coach) {
		int row = coachMapper.updateCoach(coach);
		System.out.println("row:"+row);
		return row;
	}
	@Override
	public Coach getCoachOne(int coachNo) {
		Coach coach = coachMapper.coachOne(coachNo);
		System.out.println("coach:"+coach);
		return coach;
	}

}

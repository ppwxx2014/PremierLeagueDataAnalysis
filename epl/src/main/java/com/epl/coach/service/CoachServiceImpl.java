package com.epl.coach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.coach.mapper.CoachMapper;
import com.epl.vo.Coach;
import com.epl.vo.Country;


@Service
@Transactional
public class CoachServiceImpl {
	@Autowired private CoachMapper coachMapper;
	public int addCoach(Coach coach) {
		
		return coachMapper.insertCoach(coach);
	}
	public List<Country> getCountry(){
		
		return coachMapper.selectCountry();
	}
	public List<Coach> getCoachList(){
		
		return coachMapper.selectCoachList();
	}
	
}

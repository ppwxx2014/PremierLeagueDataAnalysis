package com.epl.coach.service;

import java.util.List;

import com.epl.vo.Coach;
import com.epl.vo.Country;


public interface CoachService {
	
	public int addCoach(Coach coach);
	
	public List<Country> getCountry();
	
	public List<Coach> getCoachList();
	
}

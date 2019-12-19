package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.Coach;
import com.epl.vo.Country;

public interface CoachService {

	public int addCoach(Coach coach);

	public List<Country> getCountry();

	public List<Coach> getCoachList();
	
	public int modifyCoach(Coach coach);
	
	public Coach getCoachOne(int coachNo);

}

package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.MatchResult;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Team;


public interface MemberIndexService {
	
	public List<Team> getMemberTeamRank();
	
	public List<MatchSchedule> getMemberMatchSchedule();
	
	////
	
	public List<MatchResult> getLiveMatchList();

}

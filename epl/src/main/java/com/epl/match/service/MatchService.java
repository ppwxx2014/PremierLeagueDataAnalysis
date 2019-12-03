package com.epl.match.service;

import java.util.List;

import com.epl.vo.MatchRefree;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Refree;
import com.epl.vo.Team;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

public interface MatchService 
{
	public List<Team> teamList();
	
	public List<Refree> refreeList();
	
	public String selectStadiumByTeamName(String teamName);
	
	public int insertMatch(MatchSchedule matchSchedule);
	
	public int insertMatchRefree(MatchRefree matchRefree);
}

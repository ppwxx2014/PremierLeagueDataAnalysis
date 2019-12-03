package com.epl.match.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MatchRefree;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Refree;
import com.epl.vo.Team;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

@Mapper
public interface MatchMapper 
{
	public List<Team> selectTeamList();
	
	public List<Refree> selectRefreeList();
	
	public String selectStadiumByTeamName(String teamName);
	
	public int insertMatch(MatchSchedule matchSchedule);
	
	public int insertMatchRefree(MatchRefree matchRefree);
}

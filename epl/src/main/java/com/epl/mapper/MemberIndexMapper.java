package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MatchResult;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Team;

@Mapper
public interface MemberIndexMapper {
	
	public List<Team> selectMemberTeamRank();
	
	public List<MatchSchedule> selectMatchSchedule();
	
	public List<MatchResult> selectLiveMatchList();
}

package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MatchResult;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Team;

@Mapper
public interface MemberIndexMapper {
	
	//실시간으로 진행중인 경기의 리스트를 가져온다
	public List<MatchResult> selectLiveMatchList();
	
	public List<Team> selectMemberTeamRank();

	public List<MatchSchedule> selectMatchSchedule();
}

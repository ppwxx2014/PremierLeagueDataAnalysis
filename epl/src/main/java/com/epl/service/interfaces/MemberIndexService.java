package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.MatchResult;
import com.epl.vo.MatchSchedule;
import com.epl.vo.TeamRank;


public interface MemberIndexService {

	//실시간으로 진행중인 경기들을 가져온다
	public List<MatchResult> getLiveMatchList();

	public List<TeamRank> getMemberTeamRank();

	public List<MatchSchedule> getMemberMatchSchedule();

}

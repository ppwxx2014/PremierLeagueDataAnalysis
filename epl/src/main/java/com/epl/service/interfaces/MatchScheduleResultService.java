package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.MatchScheduleResult;

public interface MatchScheduleResultService {
	public List<MatchScheduleResult> getMatchScheduleResult();
	//public List<MatchScheduleResult> getMatchScheduleResultTwo();
	public List<MatchScheduleResult> getMatchFullSchedule();
}

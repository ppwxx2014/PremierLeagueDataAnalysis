package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MatchScheduleResult;

@Mapper
public interface MatchScheduleResultMapper {
	public List<MatchScheduleResult> selectMatchSchedulResult();
	//public List<MatchScheduleResult> selectMatchSchedulResultTwo();
	public List<MatchScheduleResult> selectMatchFullSchedul();
}

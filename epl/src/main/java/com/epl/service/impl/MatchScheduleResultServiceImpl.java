package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.MatchScheduleResultMapper;
import com.epl.service.interfaces.MatchScheduleResultService;
import com.epl.vo.MatchScheduleResult;

@Service
@Transactional
public class MatchScheduleResultServiceImpl implements MatchScheduleResultService{
	@Autowired MatchScheduleResultMapper matchScheduleResultMapper;
	
	@Override
	public List<MatchScheduleResult> getMatchScheduleResult() {
		System.out.println("서비스 실행");
		List<MatchScheduleResult> list = matchScheduleResultMapper.selectMatchSchedulResult();
		System.out.println("list:"+list);
		return list;
	}
	@Override
	public List<MatchScheduleResult> getMatchFullSchedule() {
		System.out.println("전체보기 서비스 실행");
		List<MatchScheduleResult> list = matchScheduleResultMapper.selectMatchFullSchedul();
		System.out.println("serlist:"+list);
		return list;
	}
	
//	@Override
//	public List<MatchScheduleResult> getMatchScheduleResultTwo() {
//		System.out.println("서비스 실행");
//		List<MatchScheduleResult> list = matchScheduleResultMapper.selectMatchSchedulResultTwo();
//		System.out.println("list:"+list);
//		return list;
//	}
	
}

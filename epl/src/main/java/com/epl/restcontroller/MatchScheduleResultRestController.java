package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MatchScheduleResultService;
import com.epl.vo.MatchScheduleResult;

@RestController
public class MatchScheduleResultRestController {
	@Autowired MatchScheduleResultService matchScheduleResultService;
	
	@PostMapping("/getMatchScheduleResult")
	public List<MatchScheduleResult> getMatchScheduleResult() {
		System.out.println("컨트롤러 실행");
		List<MatchScheduleResult> list = matchScheduleResultService.getMatchScheduleResult();
		System.out.println("list:"+list);
		return list;
	}
	@PostMapping("/getMatchFullSchedule")
	public List<MatchScheduleResult> getMatchFullSchedule() {
		System.out.println("더보기 컨트롤러 실행");
		List<MatchScheduleResult> list = matchScheduleResultService.getMatchFullSchedule();
		System.out.println("list:"+list);
		return list;
	}
	
//	@PostMapping("/getMatchScheduleResultTwo")
//	public List<MatchScheduleResult> getMatchScheduleResultTwo() {
//		System.out.println("컨트롤러 실행");
//		List<MatchScheduleResult> list = matchScheduleResultService.getMatchScheduleResultTwo();
//		System.out.println("list:"+list);
//		return list;
//	}
}

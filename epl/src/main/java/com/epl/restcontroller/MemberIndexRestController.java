package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MemberIndexService;
import com.epl.vo.MatchResult;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Team;

@RestController
public class MemberIndexRestController {
	@Autowired
	private MemberIndexService memberIndexService;
	
	@PostMapping("/member/getLiveMatchList")
	public List<MatchResult> getLiveMatchList() {
		List<MatchResult> list = memberIndexService.getLiveMatchList();
		System.out.println("-----getLiveMatchList Controller-----");
		System.out.println("LiveMatchList : " + list);
		return list;
	}
}

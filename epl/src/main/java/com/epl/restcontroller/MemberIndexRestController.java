package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MemberIndexService;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Team;

@RestController
public class MemberIndexRestController {
	@Autowired
	private MemberIndexService memberIndexService;
	
	@PostMapping("/member/getTeamRank")
	public List<Team> getTeamRank() {
		List<Team> list = memberIndexService.getMemberTeamRank();
		System.out.println("list:" + list);
		return list;
	}
	@PostMapping("/member/getMatchSchedule")
	public List<MatchSchedule> getMatchSchedule() {
		List<MatchSchedule> list = memberIndexService.getMemberMatchSchedule();
		System.out.println("list:" + list);
		return list;
	}
}

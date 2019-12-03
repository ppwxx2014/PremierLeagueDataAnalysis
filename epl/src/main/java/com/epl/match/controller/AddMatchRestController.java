package com.epl.match.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.match.service.MatchService;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Refree;
import com.epl.vo.Team;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

@RestController
public class AddMatchRestController 
{
	@Autowired MatchService matchService;
	
	@PostMapping("/teamList")
	public List<Team> teamList()
	{
		System.out.println("-----team restController 진입-----");
		List<Team> homeTeamList = matchService.teamList();
		return homeTeamList;
	}
	
	@PostMapping("/refreeList")
	public List<Refree> refreeList()
	{
		System.out.println("-----refree restController 진입-----");
		List<Refree> refreeList = matchService.refreeList();
		return refreeList;
	}
	
	@PostMapping("/stadium")
	public String stadium(@RequestParam("teamName") String teamName)
	{
		System.out.println("-----stadium restController 진입-----");
		System.out.println("선택된 홈팀 :" + teamName);
		String stadium = matchService.selectStadiumByTeamName(teamName);
		return stadium;
	}
	
	@PostMapping("/insertMatch")
	public String insertMatch(MatchSchedule matchSchedule,
							  @RequestParam("refreeNo") int refreeNo)
	{
		System.out.println("-----match insert restController 진입-----");
		System.out.println("입력할 매치 :" + matchSchedule);
		System.out.println("입력할 심판No :" + refreeNo);
		int matchNo = matchService.insertMatch(matchSchedule);
		if(matchNo != 0)
		{
			System.out.println("매치입력 성공");
			System.out.println("입력된 matchNo : " + matchNo);
			MatchRefree matchRefree = new MatchRefree();
			matchRefree.setRefreeNo(refreeNo);
			matchRefree.setMatchNo(matchNo);
			int check = matchService.insertMatchRefree(matchRefree);
			
			if( check != 0)
			{
				System.out.println("매치심판입력 성공");
			}
		}
		return null;
	}
}

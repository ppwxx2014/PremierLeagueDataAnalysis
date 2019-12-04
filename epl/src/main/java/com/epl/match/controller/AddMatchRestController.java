package com.epl.match.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.match.service.MatchService;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Player;
import com.epl.vo.PlayerInfo;
import com.epl.vo.Refree;
import com.epl.vo.Team;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

@RestController
public class AddMatchRestController 
{
	@Autowired MatchService matchService;
	//팀의 리스트를 가져오는 매서드 (수정필요 : enum이 t인 팀)
	@PostMapping("/teamList")
	public List<Team> teamList()
	{
		System.out.println("-----team restController 진입-----");
		List<Team> homeTeamList = matchService.teamList();
		return homeTeamList;
	}
	// 심판의 이름 리스트를 가져오는 매서드
	@PostMapping("/refreeList")
	public List<Refree> refreeList()
	{
		System.out.println("-----refree restController 진입-----");
		List<Refree> refreeList = matchService.refreeList();
		return refreeList;
	}
	// 경기장의 리스트를 가져오는 매서드
	@PostMapping("/stadium")
	public String stadium(@RequestParam("teamName") String teamName)
	{
		System.out.println("-----stadium restController 진입-----");
		System.out.println("선택된 홈팀 :" + teamName);
		String stadium = matchService.selectStadiumByTeamName(teamName);
		return stadium;
	}
	// Match Schedule을 insert하기위한 테이블
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
	//경기번호의 홈팀 선수목록을 가져오는 매서드  = 경기 선수,경기 키퍼를 만들기위한 매서드
	@PostMapping("/selectMatchList")
	public List<MatchSchedule> selectMatchList()
	{
		System.out.println("-----selectMatchList restController 진입-----");
		List<MatchSchedule> list = matchService.selectMatchList();
		return list;
	}
	//선택한 경기의 One을 가져오는 매서드
	@PostMapping("/selectMatchOne")
	public MatchSchedule selectMatchOne(@RequestParam("matchNo") int matchNo)
	{
		System.out.println("-----selectMatchOne restController 진입-----");
		System.out.println("선택한 경기의 matchNo : " + matchNo);
		MatchSchedule matchSchedule = matchService.selectMatchOne(matchNo);
		return matchSchedule;
	}
	
	@PostMapping("/selectPlayerByTeam")
	public List<PlayerInfo> selectPlayerByTeam(@RequestParam("teamName") String teamName)
	{
		System.out.println("-----player List restController 진입-----");
		System.out.println("가져올 선수들의 팀이름 : " + teamName);
		List<PlayerInfo> list = matchService.selectPlayerListByTeamName(teamName);
		return list;
	}
	
}

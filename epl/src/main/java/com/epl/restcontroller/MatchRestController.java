package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MatchService;
import com.epl.vo.MatchPlayerNo;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchSchedule;
import com.epl.vo.PlayerInfo;
import com.epl.vo.Refree;
import com.epl.vo.Team;

@RestController
public class MatchRestController 
{
	@Autowired MatchService matchService;
	//팀의 리스트를 가져오는 매서드 (수정필요 : enum이 t인 팀)
	
	@PostMapping("/teamList")
	public List<Team> getTeamList()
	{
		System.out.println("-----team restController 진입-----");
		List<Team> list = matchService.getTeamList();
		return list;
	}
	// 심판의 이름 리스트를 가져오는 매서드
	@PostMapping("/getRefreeList")
	public List<Refree> refreeList()
	{
		System.out.println("-----refree restController 진입-----");
		List<Refree> refreeList = matchService.getRefreeList();
		return refreeList;
	}
	// 경기장의 리스트를 가져오는 매서드
	@PostMapping("/getStadiumByTeamName")
	public String stadium(@RequestParam("teamName") String teamName)
	{
		System.out.println("-----stadium restController 진입-----");
		System.out.println("선택된 홈팀 :" + teamName);
		String stadium = matchService.getStadiumByTeamName(teamName);
		return stadium;
	}
	// Match Schedule을 insert하기위한 테이블
	@PostMapping("/addMatch")
	public String insertMatch(MatchSchedule matchSchedule,
							  @RequestParam("refreeNo") int refreeNo)
	{
		System.out.println("-----match insert restController 진입-----");
		System.out.println("입력할 매치 :" + matchSchedule);
		System.out.println("입력할 심판No :" + refreeNo);
		int matchNo = matchService.addMatch(matchSchedule);
		if(matchNo != 0)
		{
			System.out.println("매치입력 성공");
			System.out.println("입력된 matchNo : " + matchNo);
			MatchRefree matchRefree = new MatchRefree();
			matchRefree.setRefreeNo(refreeNo);
			matchRefree.setMatchNo(matchNo);
			int check = matchService.addMatchRefree(matchRefree);
			
			if( check != 0)
			{
				System.out.println("매치심판입력 성공");
			}
		}
		return null;
	}
	//경기번호의 홈팀 선수목록을 가져오는 매서드  = 경기 선수,경기 키퍼를 만들기위한 매서드
	@PostMapping("/getMatchList")
	public List<MatchSchedule> selectMatchList()
	{
		System.out.println("-----selectMatchList restController 진입-----");
		List<MatchSchedule> list = matchService.getMatchList();
		return list;
	}
	//선택한 경기의 One을 가져오는 매서드
	@PostMapping("/getMatchOne")
	public MatchSchedule selectMatchOne(@RequestParam("matchNo") int matchNo)
	{
		System.out.println("-----selectMatchOne restController 진입-----");
		System.out.println("선택한 경기의 matchNo : " + matchNo);
		MatchSchedule matchSchedule = matchService.getMatchOne(matchNo);
		return matchSchedule;
	}
	
	//팀이름을 param으로 주고 해당 팀의 선수 리스트를 가져오는 매서드
	@PostMapping("/getPlayerListByTeamName")
	public List<PlayerInfo> selectPlayerByTeam(@RequestParam("teamName") String teamName)
	{
		System.out.println("-----player List restController 진입-----");
		System.out.println("가져올 선수들의 팀이름 : " + teamName);
		List<PlayerInfo> list = matchService.getPlayerListByTeamName(teamName);
		return list;
	}
	
	//startingLineUp 페이지에서 입력한 값들은 각자에 맞는 양식으로 match_player, match_keeper에 insert하는 매서드
	@PostMapping("/addMatchPlayerKeeper")
	public String addMatchPlayerKeeper(@RequestParam("mainPlayerNo[]") List<String> mainPlayerNo,
									   @RequestParam("KeeperNo[]") List<String> KeeperNo,
									   @RequestParam("subPlayerNo[]") List<String> subPlayerNo,
									   @RequestParam("matchNo") int matchNo)
	{
		System.out.println("-----add Match Player Keeper restController 진입-----");
		System.out.println("startTime 0으로 matchPlayer에 insert : "+mainPlayerNo);
		System.out.println("startTime 0으로 matchKeeper에 insert : "+KeeperNo);
		System.out.println("startTime (null)으로 matchPlayer에 insert : "+subPlayerNo);
		System.out.println("입력할 경기의 No : "+matchNo);
		int mainCheck = 0;
		int subCheck = 0;
		int keeperCheck = 0;
		//메인선수들 입력
		for(int i=0;i<mainPlayerNo.size();i++)
		{
			MatchPlayerNo matchPlayerNo = new MatchPlayerNo();
			matchPlayerNo.setMatchNo(matchNo);
			matchPlayerNo.setPlayerNo(mainPlayerNo.get(i));
			int check = matchService.addMainPlayer(matchPlayerNo);
			mainCheck = mainCheck+check;
		}
		System.out.println("20이면 메인선수 입력 성공 : " + mainCheck);
		//서브선수들 입력
		for(int i=0;i<subPlayerNo.size();i++)
		{
			MatchPlayerNo matchPlayerNo = new MatchPlayerNo();
			matchPlayerNo.setMatchNo(matchNo);
			matchPlayerNo.setPlayerNo(subPlayerNo.get(i));
			int check = matchService.addSubPlayer(matchPlayerNo);
			subCheck = subCheck+check;
		}
		System.out.println("14이면 서브선수 입력 성공 : " + subCheck);
		//골키퍼 둘 입력
		for(int i=0;i<KeeperNo.size();i++)
		{
			MatchPlayerNo matchPlayerNo = new MatchPlayerNo();
			matchPlayerNo.setMatchNo(matchNo);
			matchPlayerNo.setPlayerNo(KeeperNo.get(i));
			int check = matchService.addKeeper(matchPlayerNo);
			keeperCheck = keeperCheck+check;
		}
		System.out.println("2면 키퍼 입력 성공 : " + keeperCheck);
		return null;
	}
	
}

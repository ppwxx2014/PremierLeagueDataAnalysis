package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MatchService;
import com.epl.vo.InGamePosition;
import com.epl.vo.MatchCheckKeeper;
import com.epl.vo.MatchGoalKeeper;
import com.epl.vo.MatchGoals;
import com.epl.vo.MatchNoTeamName;
import com.epl.vo.MatchOwnGoals;
import com.epl.vo.MatchPlayer;
import com.epl.vo.MatchPlayerNo;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchResult;
import com.epl.vo.MatchSchedule;
import com.epl.vo.PlayerInfo;
import com.epl.vo.Refree;
import com.epl.vo.Team;

@RestController
public class MatchRestController 
{
	@Autowired MatchService matchService;
	//팀의 리스트를 가져오는 매서드 (수정필요 : enum이 t인 팀)
	
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
				MatchResult matchResult = new MatchResult();
				matchResult.setMatchNo(matchNo);
				matchResult.setHometeamName(matchSchedule.getHometeamName());
				matchResult.setAwayteamName(matchSchedule.getAwayteamName());
				int check2 = matchService.addMatchResult(matchResult);
				if(check2 != 0)
				{
					System.out.println("매치결과 입력 성공");	
				}	
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
	
	//startingLineUp 페이지에서 입력한 값들은 각자에 맞는 양식으로 match_player, match_keeper에 insert하는 매서드
	@PostMapping("/addMatchPlayerKeeper")
	public String addMatchPlayerKeeper(@RequestParam("mainPlayerNo[]") List<String> mainPlayerNo,
									   @RequestParam("KeeperNo[]") List<String> KeeperNo,
									   @RequestParam("subPlayerNo[]") List<String> subPlayerNo,
									   @RequestParam("matchNo") int matchNo,
									   @RequestParam("matchTime") String matchTime)
	{
		System.out.println("-----add Match Player Keeper restController 진입-----");
		System.out.println("startTime 0으로 matchPlayer에 insert : "+mainPlayerNo);
		System.out.println("startTime 0으로 matchKeeper에 insert : "+KeeperNo);
		System.out.println("startTime (null)으로 matchPlayer에 insert : "+subPlayerNo);
		System.out.println("입력할 경기의 No : "+matchNo);
		System.out.println("입력할 경기의 matchTime : "+matchTime);
		int mainCheck = 0;
		int subCheck = 0;
		int keeperCheck = 0;
		//메인선수들 입력
		for(int i=0;i<mainPlayerNo.size();i++)
		{
			MatchPlayerNo matchPlayerNo = new MatchPlayerNo();
			matchPlayerNo.setMatchNo(matchNo);
			matchPlayerNo.setPlayerNo(mainPlayerNo.get(i));
			matchPlayerNo.setMatchTime(matchTime);
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
			matchPlayerNo.setMatchTime(matchTime);
			int check = matchService.addKeeper(matchPlayerNo);
			keeperCheck = keeperCheck+check;
		}
		System.out.println("2면 키퍼 입력 성공 : " + keeperCheck);
		return null;
	}
	
	//이경기에 이선수가 골키퍼로 뛰고있는지 아닌지 검사하는 매서드
	@PostMapping("/playercheck")
	public String matchPlayer(MatchCheckKeeper matchCheckKeeper)
	{
		System.out.println("-----matchPlayer restController 진입-----");
		System.out.println("포지션을 검색할 선수의 No : "+matchCheckKeeper.getPlayerNo());
		System.out.println("경기의 No : "+matchCheckKeeper.getMatchNo());
	
		MatchCheckKeeper check = matchService.checkKeeper(matchCheckKeeper);
		String position = null;
		System.out.println("check: "+check);
		if(check != null)
		{
			System.out.println("골키퍼다");
			position = "GK";
		}
		else
		{
			System.out.println("아니다");
			position = "FW,MF,DF";
		}
		return position;
	}
	
	//MatchPlayerOne을가져오는 매서드
	@PostMapping("/getMatchPlayerOne")
	public MatchPlayer  getMatchPlayerOne(MatchPlayer matchPlayer)
	{
		System.out.println("-----getMatchPlayerOne restController 진입-----");
		System.out.println("검색할 선수의 No : "+matchPlayer.getPlayerNo());
		System.out.println("경기 No : "+matchPlayer.getMatchNo());
		MatchPlayer check = matchService.getMatchPlayerOne(matchPlayer);
		System.out.println("가져온 매치플레이어 : " + check);
		return check;
	}
	
	//MatchGoalKeeperOne를 가져오는 매서드
	@PostMapping("/getMatchGoalKeeperOne")
	public MatchGoalKeeper  getMatchGoalKeeperOne(MatchGoalKeeper matchGoalKeeper)
	{
		System.out.println("-----getMatchGoalKeeperOne restController 진입-----");
		System.out.println("검색할 키퍼의 No : "+matchGoalKeeper.getPlayerNo());
		System.out.println("경기 No : "+matchGoalKeeper.getMatchNo());
		MatchGoalKeeper check = matchService.getMatchGoalKeeperOne(matchGoalKeeper);
		System.out.println("가져온 매치플레이어 : " + check);
		return check;
	}
	
	// 매치선수를 기록하는매서드
	@PostMapping("/modifyMatchPlayer")
	public int modifyMatchPlayer(MatchPlayer matchPlayer)
	{
		System.out.println("-----modifyMatchPlayer restController 진입-----");
		System.out.println("입력할 matchPlayer : " + matchPlayer);
		if(matchPlayer.getStartTime().equals(""))
		{
			matchPlayer.setStartTime(null);
		}
		if(matchPlayer.getEndTime().equals(""))
		{
			matchPlayer.setEndTime(null);
		}
		int check = matchService.modifyMatchPlayer(matchPlayer);
		System.out.println("선수 기록 입력 성공 ? : "+ check);
		return check; 
	}
	
	//교체된 키퍼의 시작시간을 현재시간으로 업데이트하는 매서드
	@PostMapping("/modifyMatchPlayerT")
	public int modifyMatchPlayerT(MatchPlayer matchPlayer)
	{
		System.out.println("-----modifyMatchPlayer restController 진입-----");
		System.out.println("입력할 matchPlayer : " + matchPlayer);
		if(matchPlayer.getStartTime().equals(""))
		{
			matchPlayer.setStartTime(null);
		}
		if(matchPlayer.getEndTime().equals(""))
		{
			matchPlayer.setEndTime(null);
		}
		int check = matchService.modifyMatchPlayerT(matchPlayer);
		System.out.println("후보 시작 기록 입력 성공 ? : "+ check);
		return check; 
	}
	
	//골을 넣을시 골테이블에 기록하는매서드
	@PostMapping("/addMatchGoals")
	public int addMatchGoals(MatchGoals matchGoals)
	{
		System.out.println("-----addMatchGoals restController 진입-----");
		System.out.println("골을 넣은 선수 No : " + matchGoals.getPlayerNo());
		System.out.println("골을 넣은 경기 No : " + matchGoals.getMatchNo());
		int check = matchService.addMatchGoals(matchGoals);
		System.out.println("골 넣은 기록 입력 성공 ? : "+ check);
		return check; 
	}
	
	//자살골을 자살골테이블에 기록하는 매서드
	@PostMapping("/addMatchOwnGoals")
	public int addMatchOwnGoals(MatchOwnGoals matchOwnGoals)
	{
		System.out.println("-----addMatchGoals restController 진입-----");
		System.out.println("자책골을 넣은 선수 No : " + matchOwnGoals.getPlayerNo());
		System.out.println("자책골을 넣은 경기 No : " + matchOwnGoals.getMatchNo());
		int check = matchService.addMatchOwnGoals(matchOwnGoals);
		System.out.println("자책골 넣은 기록 입력 성공 ? : "+ check);
		return check; 
	}
	
	//골을 넣은후 결과테이블에 점수를 추가하는 매서드
	@PostMapping("/modifyMatchResultByGoal")
	public int modifyMatchResultByGoal(MatchGoals matchGoals)
	{
		System.out.println("-----modifyMatchResultByGoal restController 진입-----");
		System.out.println("골을 넣은 선수 No : " + matchGoals.getPlayerNo());
		System.out.println("골을 넣은 경기 No : " + matchGoals.getMatchNo());
		int check = matchService.modifyMatchResultByGoal(matchGoals);
		System.out.println("골넣었을때 실시간테이블 업데이트 성공 ? : "+ check);
		return check;
	}
	
	//자살골을 넣은후 결과 테이블에 점수를 추가하는 매서드
	@PostMapping("/modifyMatchResultByOwnGoal")
	public int modifyMatchResultByOwnGoal(MatchOwnGoals matchOwnGoals)
	{
		System.out.println("-----modifyMatchResultByOwnGoal restController 진입-----");
		System.out.println("골을 넣은 선수 No : " + matchOwnGoals.getPlayerNo());
		System.out.println("골을 넣은 경기 No : " + matchOwnGoals.getMatchNo());
		int check = matchService.modifyMatchResultByOwnGoal(matchOwnGoals);
		System.out.println(" 자책골넣었을때 실시간테이블 업데이트 성공 ? : "+ check);
		return check;
	}
	
	//골키퍼의 기록을 입력하는 매서드
	@PostMapping("/modifyMatchKeeper")
	public int modifyMatchKeeper(MatchGoalKeeper matchGoalKeeper)
	{
		System.out.println("-----modifyMatchKeeper restController 진입-----");
		System.out.println("입력할 키퍼의 기록 : "+ matchGoalKeeper);
		if(matchGoalKeeper.getStartTime().equals(""))
		{
			matchGoalKeeper.setStartTime(null);
		}
		if(matchGoalKeeper.getEndTime().equals(""))
		{
			matchGoalKeeper.setEndTime(null);
		}
		int check = matchService.modifyMatchKeeper(matchGoalKeeper);
		System.out.println("키퍼 기록 업데이트 성공? : "+ check);
		return check;
	}
	
	//교체된 골키퍼의 시작시간을 현재시간으로 업데이트하는 매서드
	@PostMapping("/modifyMatchKeeperT")
	public int modifyMatchKeeperT(MatchGoalKeeper matchGoalKeeper)
	{
		System.out.println("-----modifyMatchKeeper restController 진입-----");
		System.out.println("입력할 키퍼의 기록 : "+ matchGoalKeeper);
		if(matchGoalKeeper.getStartTime().equals(""))
		{
			matchGoalKeeper.setStartTime(null);
		}
		if(matchGoalKeeper.getEndTime().equals(""))
		{
			matchGoalKeeper.setEndTime(null);
		}
		int check = matchService.modifyMatchKeeperT(matchGoalKeeper);
		System.out.println("키퍼 기록 업데이트 성공? : "+ check);
		return check;
	}
	
	//팀이름과 경기넘버를주고 경기 선수리스트를 가져오는매서드
	@PostMapping("/getMainAndKeeper")
	public List<InGamePosition> getInGamePosition(MatchNoTeamName matchNoTeamName)
	{
		System.out.println("-----getInGamePosition restController 진입-----");
		System.out.println("가져올 선수리스트의 경기NO와 팀이름 : "+ matchNoTeamName);
		List<InGamePosition> list = matchService.getMainAndKeeper(matchNoTeamName);
		System.out.println(list);
		for (InGamePosition a: list) {
			if(a.getInGamePosition()==null)
			{
				a.setInGamePosition("교체 투입된 키퍼");
			}
		}
		return list;
	}
	
	//팀이름과 경기넘버를주고 경기 gnqh리스트를 가져오는매서드
		@PostMapping("/getCommutablePlayer")
		public List<InGamePosition> getCommutablePlayer(MatchNoTeamName matchNoTeamName)
		{
			System.out.println("-----getCommutablePlayer restController 진입-----");
			System.out.println("가져올 후보리스트의 경기NO와 팀이름 : "+ matchNoTeamName);
			List<InGamePosition> list = matchService.getCommutablePlayer(matchNoTeamName);
			System.out.println(list);
			return list;
		}
	
	// 해당하는 팀의 모든선수들을 출력하는매서드
	@PostMapping("/getPlayerListByTeamName")
	public List<PlayerInfo> selectPlayerByTeam(@RequestParam("teamName") String teamName)
	{
		System.out.println("-----player List restController 진입-----");
		System.out.println("가져올 선수들의 팀이름 : " + teamName);
		List<PlayerInfo> list = matchService.getPlayerListByTeamName(teamName);
		return list;
	}
	
	//후보선수가 골키퍼로 투입될때 플레이어테이블에서 지우는 매서드
	@PostMapping("/removeMatchPlayer")
	public int removeMatchPlayer(MatchPlayer matchPlayer)
	{
		System.out.println("-----removeMatchPlayer restController 진입-----");
		System.out.println("matchPlayer에서 삭제할 선수NO,매치No : " + matchPlayer);
		int check = matchService.removeMatchPlayer(matchPlayer);
		return check;
	}
	
	//후보선수가 골키퍼로 교체될때 키퍼테이블에 후보선수를 입력하는 매서드
	@PostMapping("/addMatchKeeper")
	public int addMatchKeeper(MatchPlayerNo matchPlayerNo)
	{
		System.out.println("-----addMatchKeeper restController 진입-----");
		System.out.println("입력할 교대 골키퍼 MatchNo.playerNo,startTime : " + matchPlayerNo);
		int check = matchService.addKeeper(matchPlayerNo);
		return 0;
	}
	
	//진행중인 게임의 우리팀 키퍼가 퇴장당했는지 검색하는 매서드
	@PostMapping("/checkMatchKeeperT")
	public int checkMatchKeeperT(MatchNoTeamName matchNoTeamName)
	{
		System.out.println("-----checkMatchKeeperT restController 진입-----");
		System.out.println("이경기 이팀에 우리 골키퍼가 ative인지 검색 : " + matchNoTeamName);
		int check = 10;
		if(matchService.getMatchKeeperT(matchNoTeamName)==null)
		{
			check = 0;
		}
		else
		{
			check = 1;
		}
		System.out.println("??? :" + check);
		return check;
	}
	
	@PostMapping("/getLatelyEndTimeOfKeeper")
	public InGamePosition getLatelyEndTimeOfKeeper(MatchNoTeamName matchNoTeamName)
	{
		System.out.println("-----getLatelyEndTimeOfKeeper restController 진입-----");
		System.out.println("최근에 퇴장당한 키퍼의 퇴장시간을 검색(팀이름 경기No) : " + matchNoTeamName);
		InGamePosition check = matchService.getLatelyEndTimeOfKeeper(matchNoTeamName);
		return check;
	}
	
	@PostMapping("/insertPlayerToKeeper")
	public int addPlayerToKeeper(MatchPlayerNo matchPlayerNo)
	{
		System.out.println("-----addPlayerToKeeper restController 진입-----");
		System.out.println("선수가 키퍼로투입됨 : " + matchPlayerNo);
		int check = matchService.addKeeper(matchPlayerNo);
		return check;
	}
	
	@PostMapping("/finishMatch")
	public int finishMatch(@RequestParam(value = "matchNo") int matchNo) {
		System.out.println("-----finishMatch restController 진입-----");
		System.out.println("matchNo : " + matchNo);
		int check1 = matchService.modifyMatchScheduleF(matchNo);
		int check2 = matchService.modifyPlayerF(matchNo);
		int check3 = matchService.modifyKeeperF(matchNo);
		
		System.out.println(check1 + check2 + check3);
		MatchResult matchResult = matchService.getMatchScore(matchNo);
		System.out.println(matchResult);
		
		int hometeamGoals = matchResult.getHometeamGoals();
		int awayteamGoals = matchResult.getAwayteamGoals();
		
		String hometeamName = matchResult.getHometeamName();
		String awayteamName = matchResult.getAwayteamName();
		
		
		
		if(hometeamGoals > awayteamGoals) {
			matchResult.setWinnerteamName(hometeamName);
		} else if(awayteamGoals > hometeamGoals) {
			matchResult.setWinnerteamName(awayteamName);
		} else if(hometeamGoals == awayteamGoals) {
			matchResult.setWinnerteamName("draw");
		}
		
		int check4 = matchService.modifyMatchResult(matchResult);
		
		System.out.println("4가 나오면 성공: " + check1+check2+check3+check4);
		
		int row = check1+check2+check3+check4;
		
		return row;
	}
	
	@PostMapping("/getMatchScore")
	public MatchResult getMatchScore(@RequestParam(value = "matchNo") int matchNo) {
		System.out.println("-----getMatchScore restController 진입-----");
		System.out.println("matchNo : " + matchNo);
		
		MatchResult matchResult = matchService.getMatchScore(matchNo);
		System.out.println(matchResult);
		
		return matchResult;
	}
	
	
	
}





















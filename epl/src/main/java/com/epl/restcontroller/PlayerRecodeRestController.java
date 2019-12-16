package com.epl.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.PlayerRecodeService;
import com.epl.vo.MatchGoalKeeper;
import com.epl.vo.MatchGoals;
import com.epl.vo.MatchOwnGoals;
import com.epl.vo.MatchPlayer;
import com.epl.vo.Player;


@RestController
public class PlayerRecodeRestController {
	@Autowired PlayerRecodeService playerRecodeService;
	
	@PostMapping("/getMemberPlayerRecode")
	public MatchPlayer getMemberPlayerRecode(@RequestParam(value = "playerNo")int playerNo) {

		MatchPlayer matchPlayer = playerRecodeService.getMemberPlayerRecode(playerNo);
		System.out.println("conmatchPlayer:"+matchPlayer);
		return matchPlayer;
	}
	@PostMapping("/getMemberPlayerGoals")
	public MatchGoals getMemberPlayerGoals(@RequestParam(value = "playerNo")int playerNo) {

		MatchGoals matchGoals = playerRecodeService.getMemberPlayerGoals(playerNo);
		System.out.println("conmatchGoals:"+matchGoals);
		return matchGoals;
	}
	@PostMapping("/getMemberPlayerOwnGoals")
	public MatchOwnGoals getMemberPlayerOwnGoals(@RequestParam(value = "playerNo")int playerNo) {
		MatchOwnGoals matchOwnGoals = playerRecodeService.getMemberPlayerOwnGoals(playerNo);
		System.out.println("matchOwnGoals:"+matchOwnGoals);
		return matchOwnGoals;
	}
	@PostMapping("/getMemberGoalKeeperRecode")
	public MatchGoalKeeper getMemberGoalKeeperRecode(@RequestParam(value = "playerNo")int playerNo) {
		MatchGoalKeeper matchGoalKeeper = playerRecodeService.getMemberGoalKeeperRecode(playerNo);
		System.out.println("conmatchGoalKeeper:"+matchGoalKeeper);
		return matchGoalKeeper;
	}
	//getMemberPlayerOne에 속한 결과값이라  불필요
	/*@PostMapping("/getMemberPlayerName")
	public Player getMemberPlayerName(HttpSession session) {
		int playerNo = (int)session.getAttribute("playerNo");
		Player player = playerRecodeService.getMemberPlayerName(playerNo);
		System.out.println("conplayer:"+player);
		return player;
	}*/
}

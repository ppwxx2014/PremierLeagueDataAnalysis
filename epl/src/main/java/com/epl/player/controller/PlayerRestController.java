package com.epl.player.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.player.service.PlayerService;
import com.epl.vo.Player;

@RestController
public class PlayerRestController {
	@Autowired private PlayerService playerservice;

	@PostMapping("/addPlayer")
	public int addPlayer(Player player){
		System.out.println("addPlayer 입력");
		System.out.println("param player: " + player);
		int row = playerservice.addPlayer(player);
		return row;
	}
	@PostMapping("/getPlayerList")
	public List<Player> getPlayerList() {
		System.out.println("getPlayerList 요청");
		List<Player> list = playerservice.getPlayerList();
		System.out.println("playerController @PostMapping list :"+list);
		return list;
	}
	/*
	@PostMapping("/addPlayerPosition")
	public int addPlayerPosition(@RequestParam(value = "playerNo") int playerNo ,
									@RequestParam(value = "positionNo") int positionNo) {
		System.out.println("선수 포지션 입력 매개변수 값 : positionNo , playerNo :" + positionNo +"/"+playerNo);
		
		System.out.println("playerNo 셋팅 값 : "+playerNo);
		
		PlayerPosition playerPosition = new PlayerPosition();
		
		playerPosition.setPlayerNo(playerNo);
		playerPosition.setPositionNo(positionNo);
		
		int row = playerservice.addPlayerPosition(playerPosition);
		
		return row;
	}
	*/
}

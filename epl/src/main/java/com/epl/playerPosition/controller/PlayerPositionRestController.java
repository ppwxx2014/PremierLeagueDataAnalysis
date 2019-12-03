package com.epl.playerPosition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.playerPosition.service.PlayerPositionService;
import com.epl.vo.PlayerPosition;

@RestController
public class PlayerPositionRestController {
	@Autowired private PlayerPositionService playerPositionService;
	
	@PostMapping("/addPlayerPosition")
	public int addPlayerPosition(@RequestParam(value = "playerNo") int playerNo ,
									@RequestParam(value = "positionNo") int positionNo) {
		System.out.println("선수 포지션 입력 매개변수 값 : positionNo , playerNo :" + positionNo +"/"+playerNo);
		
		System.out.println("playerNo 셋팅 값 : "+playerNo);
		
		PlayerPosition playerPosition = new PlayerPosition();
		
		playerPosition.setPlayerNo(playerNo);
		playerPosition.setPositionNo(positionNo);
		
		int row = playerPositionService.addPlayerPosition(playerPosition);
		
		return row;
	}
}
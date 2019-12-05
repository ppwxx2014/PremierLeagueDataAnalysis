package com.epl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.epl.service.interfaces.PlayerService;

@Controller
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	// 플레이어 입력폼
	@GetMapping("/addPlayer")
	public String addPlayer() {
		System.out.println("addPlayer 폼요청");
		return "addPlayer";
	};

	@GetMapping("/getPlayerList")
	public String getPlayerList() {
		System.out.println("getPlayerList 요청");
		/*
		 * List<Player> list = playerService.getPlayerList();
		 * System.out.println("playerController @PostMapping list :" + list);
		 */
		return "getPlayerList";
	}
}

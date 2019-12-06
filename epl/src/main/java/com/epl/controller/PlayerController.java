package com.epl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "player/addPlayer";
	};

	@GetMapping("/getPlayerList")
	public String getPlayerList() {
		System.out.println("getPlayerList 요청");
		
		return "player/getPlayerList";
	}
	@GetMapping("/modifyPlayer")
	public String modifyPlayer() {
		System.out.println("modifyPlayer 요청");
		
		return "player/modifyPlayer";
	}
}

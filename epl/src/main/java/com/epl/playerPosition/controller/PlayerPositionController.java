package com.epl.playerPosition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.epl.playerPosition.service.PlayerPositionService;

@Controller
public class PlayerPositionController {
	@Autowired private PlayerPositionService playerPositionService;
	
	@GetMapping("/addPlayerPosition")
	public String addPlayerPosition() {
		System.out.println("addPlayerPosition 폼요청");
		return "addPlayerPosition";
	}
}

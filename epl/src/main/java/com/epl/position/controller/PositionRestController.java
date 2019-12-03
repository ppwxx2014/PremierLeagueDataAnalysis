package com.epl.position.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.position.service.PositionService;
import com.epl.vo.Position;

@RestController
public class PositionRestController {
	@Autowired PositionService positionService;
	
	@PostMapping("/positionNo")
	public int getPositionNo(Position position) {
		System.out.println("positionNo 폼요청 param : "+ position);
		return positionService.selectPositionNo(position);
	}
}

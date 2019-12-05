package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.PositionService;
import com.epl.vo.Position;

@RestController
public class PositionRestController {
	@Autowired
	PositionService positionService;

	@PostMapping("/getPositionList")
	public List<Position> getPositionList() {
		System.out.println("positionNo 폼요청 param : ");
		return positionService.getPositionList(); // 포지션 4개 리턴
	}
}

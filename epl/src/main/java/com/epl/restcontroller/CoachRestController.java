package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.CoachService;
import com.epl.vo.Coach;
import com.epl.vo.Country;

@RestController
public class CoachRestController {
	@Autowired
	private CoachService coachService;

	@PostMapping("/getCountry")
	public List<Country> getCountry() {
		List<Country> list = coachService.getCountry();
		System.out.println("counlist:" + list);
		return list;
	}
	@PostMapping("/addCoach")
	public int addCoach(Coach coach) {
		int row = coachService.addCoach(coach);
		System.out.println("row:"+row);
		return row;
	}

	@PostMapping("/getCoachList")
	public List<Coach> getCoachList() {
		List<Coach> list = coachService.getCoachList();
		System.out.println("coachlist:" + list);
		return list;
	}
	
	@PostMapping("/modifyCoach")
	public int modifyCoach(Coach coach) {
		int row = coachService.modifyCoach(coach);
		System.out.println("row:"+row);
		return row;
	}
	@PostMapping("/getCoachOne")
	public Coach getCoachOne(int coachNo) {
		Coach coach = coachService.getCoachOne(coachNo);
		System.out.println("coach:"+coach);
		return coach;
	}
}

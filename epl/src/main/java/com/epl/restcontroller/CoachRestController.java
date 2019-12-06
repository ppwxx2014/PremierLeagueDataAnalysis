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
	public String addCoach(Coach coach) {
		coachService.addCoach(coach);
		return "addCoach";
	}

	@PostMapping("/getCoachList")
	public List<Coach> getCoachList() {
		List<Coach> list = coachService.getCoachList();
		System.out.println("coachlist:" + list);
		return list;
	}
}

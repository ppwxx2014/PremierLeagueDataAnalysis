package com.epl.coach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.coach.service.CoachServiceImpl;
import com.epl.vo.Coach;
import com.epl.vo.Country;



@RestController
public class CoachRestController {
	@Autowired private CoachServiceImpl coachService;
	
	@PostMapping("/getCountry")
	public List<Country> getCountry(){
		List<Country> list = coachService.getCountry();
		System.out.println("counlist:"+list);
		return list;
	}
	@PostMapping("/getCoachList")
	public List<Coach> getCoachList(){
		List<Coach> list =coachService.getCoachList();
		System.out.println("coachlist:"+list);
		return list;
	}
}

package com.epl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epl.service.interfaces.CoachService;
import com.epl.vo.Coach;




@Controller
public class CoachController {
	@Autowired private CoachService coachService;
	@GetMapping("/addCoach")
	public String addCoach() {
		
		return "coach/addCoach";
	}
	
	
	
	
	@GetMapping("/getCoachList")
	public String getCoachList(Model model){
		List<Coach> list = coachService.getCoachList();
		model.addAttribute("list", list);
		System.out.println("list:"+list);
		return "coach/getCoachList";
	}
	@GetMapping("/modifyCoach")
	public String modifyCoach() {
		
		return "coach/modifyCoach";
	}
}

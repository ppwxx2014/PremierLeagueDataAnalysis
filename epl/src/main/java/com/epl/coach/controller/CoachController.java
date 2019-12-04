package com.epl.coach.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epl.coach.service.CoachServiceImpl;
import com.epl.vo.Coach;




@Controller
public class CoachController {
	@Autowired private CoachServiceImpl coachService;
	@GetMapping("/addCoach")
	public String addCoach(HttpSession session,Coach coach,Model model) {
		
		coach = (Coach)session.getAttribute("coach");
		model.addAttribute("coach",coach);
		
		return "coach/addCoach";
	}
	
	@PostMapping("/addCoach")
	public String addCoach(Coach coach) {
		coachService.addCoach(coach);
		return "redirect:/coach/addCoach";
	}
	
	
	@GetMapping("/getCoachList")
	public List<Coach> getCoachList(Model model){
		List<Coach> list = coachService.getCoachList();
		model.addAttribute("list", list);
		System.out.println("list:"+list);
		return list;
	}
	
}

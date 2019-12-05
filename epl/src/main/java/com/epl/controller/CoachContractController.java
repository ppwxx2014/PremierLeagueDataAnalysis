package com.epl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epl.service.interfaces.CoachContractService;
import com.epl.vo.CoachContract;

@Controller
public class CoachContractController {
	@Autowired
	private CoachContractService coachContractService;

	@GetMapping("/addCoachContract")
	public String addCoachContract(HttpSession session, CoachContract coachContract, Model model) {

		model.addAttribute("CoachContract", coachContract);
		return "/coach/addCoachContract";
	}

	@PostMapping("/coach/addCoachContract")
	public String addCoachContract(CoachContract coachContract) {
		int row = coachContractService.addCoachContract(coachContract);
		System.out.println(row);
		return "redirect:/addCoachContract";
	}
}

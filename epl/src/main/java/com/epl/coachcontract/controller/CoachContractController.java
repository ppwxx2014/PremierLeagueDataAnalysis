package com.epl.coachcontract.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epl.coachcontract.service.CoachContractServiceImpl;
import com.epl.vo.CoachContract;

@Controller
public class CoachContractController {
	@Autowired private CoachContractServiceImpl coachContractService;
	@GetMapping("/addCoachContract")
	public String addCoachContract(HttpSession session,CoachContract coachContract,Model model) {
		
		model.addAttribute("CoachContract",coachContract);
		return "addCoachContract";
	}
	@PostMapping("addCoachContract")
	public String addCoachContract(CoachContract coachContract) {
		int row = coachContractService.addCoachContract(coachContract);
		System.out.println(row);
		return "redirect:/addCoachContract";
	}
}

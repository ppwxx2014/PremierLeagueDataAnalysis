package com.epl.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.CoachContractService;
import com.epl.vo.CoachContract;



@RestController
public class CoachContractRestController {
	@Autowired CoachContractService coachContractService;
	
	@PostMapping("/addCoachContract")
	public void addCoachContract(CoachContract coachContract) {
		int row = coachContractService.addCoachContract(coachContract);
		System.out.println(row);
		
	}
}

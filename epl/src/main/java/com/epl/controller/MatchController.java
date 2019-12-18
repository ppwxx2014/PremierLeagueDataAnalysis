package com.epl.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatchController {
	@GetMapping("/addMatch")
	public String matchadd() {
		System.out.println("----------add Match----------");
		return "/match/addMatch";
	}

	@GetMapping("/startingLineUp")
	public String startingLineUp() {
		System.out.println("----------startingLineUp----------");
		return "/match/startingLineUp";
	}
	
	@GetMapping("/addPlayerRecord")
	public String addPlayerRecord() {
		System.out.println("----------addPlayerRecord----------");
		return "/match/addPlayerRecord";
	}
	@GetMapping("/finishMatch")
	public String finishMatch() {
		System.out.println("----------finishMatch----------");
		return "/match/finishMatch";
	}
	@GetMapping("/matchResult")
	public String matchResult() {
		System.out.println("----------matchResult----------");
		return "/match/matchResult";
	}
	@GetMapping("/matchSchedule")
	public String matchSchedule() {
		System.out.println("----------matchSchedule----------");
		return "/match/matchSchedule";
	}
}

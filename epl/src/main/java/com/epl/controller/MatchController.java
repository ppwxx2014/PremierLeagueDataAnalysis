package com.epl.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatchController {
	@GetMapping("/addMatch")
	public String matchadd() {
		System.out.println("----------add Match----------");
		return "addMatch";
	}

	@GetMapping("/startingLineUp")
	public String startingLineUp() {
		System.out.println("----------startingLineUp----------");
		return "startingLineUp";
	}
}

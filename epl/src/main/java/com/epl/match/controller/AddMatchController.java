package com.epl.match.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddMatchController 
{
	@GetMapping("/addMatch")
	public String matchadd() 
	{
		System.out.println("----------add Match----------");
		return "addMatch";
	}
}

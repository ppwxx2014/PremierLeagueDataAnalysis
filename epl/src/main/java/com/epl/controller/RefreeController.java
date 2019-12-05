package com.epl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.epl.service.interfaces.RefreeService;

@Controller
public class RefreeController {
	@Autowired
	private RefreeService refreeService;

	@GetMapping("/addRefree")
	public String addRefree() {
		System.out.println("addRefree Controller 폼요청");
		return "addRefree";
	}
}

package com.epl.playercontract.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epl.playercontract.service.PlayerContractService;

@Controller
public class PlayerContractController {
	@Autowired PlayerContractService playerContractService;
	
	//선수계약 입력폼
	@GetMapping("/addPlayerContract")
	public String addPlayerContract() {
		System.out.println("addPlayerContract 폼 요청");
		return "addPlayerContract";
	}
	
	// 선수계약 리스트 폼
	@GetMapping("/getPlayerContractList")
	public String getPlayerContractList( Model model, @RequestParam( value = "currentPage", defaultValue = "1" ) int currentPage,
											@RequestParam( value = "searchWord", required = false ) String searchWord ) {
		System.out.println("getPlayerContractList controller 폼 요청");
		System.out.println("currentPage: " + currentPage); // 현 페이지수
	    System.out.println("SearchWord: " + searchWord);
		
	    int rowPerPage = 10;
	    
	    Map<String, Object> map = playerContractService.getPlayerListByPage(currentPage, rowPerPage, searchWord);
	    System.out.println("getPlayerContractList controller map :" + map);
	    
	    model.addAttribute("map", map);
		return "getPlayerContractList";
	}
}

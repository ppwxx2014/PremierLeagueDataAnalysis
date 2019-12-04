package com.epl.playercontract.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.playercontract.service.PlayerContractService;
import com.epl.vo.PlayerContract;

@RestController
public class PlayerContractRestController {
	@Autowired PlayerContractService playerContractService;
	@PostMapping("/addPlayerContract")
	public int addPlayerContract(PlayerContract playerContract) {
		System.out.println("addPlayerContract 입력");
		System.out.println("param PlayerContract: " + playerContract);
		int row = playerContractService.addPlayerContract(playerContract);
		
		System.out.println("addPlayerContract RestController"+row+"행 입력!");
		
		return row;
	}
	@PostMapping("/getPlayerContractList")
	public List<PlayerContract> getPlayerContractList(){
		System.out.println("getPlayerContractList 요청");
		List<PlayerContract> list = playerContractService.getPlayerList();
		System.out.println("PlayerContractRestController @post getlist :"+list);
		return list;
	}
}

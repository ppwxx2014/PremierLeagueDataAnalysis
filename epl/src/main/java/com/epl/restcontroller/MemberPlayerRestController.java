package com.epl.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MemberplayerService;
import com.epl.vo.Player;
import com.epl.vo.PlayerContract;

@RestController
public class MemberPlayerRestController {
	@Autowired MemberplayerService memberplayerService;
	
	@PostMapping("/getMemberPlayerList")
	public List<Player> getMemberPlayerList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "searchWord", required = false) String searchWord) {
		System.out.println("getPlayerListByPage controller 폼 요청");
		System.out.println("currentPage: " + currentPage); // 현 페이지수
		System.out.println("SearchWord: " + searchWord);

		int rowPerPage = 10; // 페이지당 보여줄 갯수

		List<Player> list = memberplayerService.getMemberPlayerList(currentPage, rowPerPage, searchWord);
		System.out.println("getPlayerList controller list :" + list);
		return list;
	}
	@PostMapping("/getMemberPlayerOne")
	public Player getMemberPlayerOne(HttpSession session) {
		int playerNo = (int)session.getAttribute("playerNo");
		Player player = memberplayerService.getMemberPlayerOne(playerNo);
		System.out.println("player:"+player);
		
		return player;
	}
	@PostMapping("/getMemberPlayerInfo")
	public PlayerContract getMemberPlayerInfo(HttpSession session) {
		int playerNo = (int)session.getAttribute("playerNo");
		PlayerContract playercontract = memberplayerService.getMemberPlayerInfo(playerNo);
		System.out.println("Conplayercontract:"+playercontract);
		
		System.out.println("con:"+playerNo);
		return playercontract;
	}
}

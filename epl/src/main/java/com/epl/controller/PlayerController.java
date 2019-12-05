package com.epl.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epl.service.interfaces.PlayerService;

@Controller
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	// 플레이어 입력폼
	@GetMapping("/addPlayer")
	public String addPlayer() {
		System.out.println("addPlayer 폼요청");
		return "addPlayer";
	};

	// 플레이어 리스트 폼
	@GetMapping("/getPlayerList")
	public String getPlayerList(Model model, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "searchWord", required = false) String searchWord) {
		System.out.println("getPlayerList controller 폼 요청");
		System.out.println("currentPage: " + currentPage); // 현 페이지수
		System.out.println("SearchWord: " + searchWord);

		int rowPerPage = 10; // 페이지당 보여줄 갯수

		Map<String, Object> map = playerService.getPlayerListByPage(currentPage, rowPerPage, searchWord);
		System.out.println("getPlayerList controller map :" + map);

		model.addAttribute("map", map);
		return "getPlayerList";
	}

}

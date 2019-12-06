package com.epl.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.PlayerService;
import com.epl.vo.Page;
import com.epl.vo.Player;

@RestController
public class PlayerRestController {
	@Autowired
	private PlayerService playerService;

	@PostMapping("/addPlayer")
	public int addPlayer(Player player) {
		System.out.println("addPlayer 입력");
		System.out.println("param player: " + player);
		int row = playerService.addPlayer(player);
		return row;
	}
	@PostMapping("/getPlayerList")
	public List<Player> getPlayerList(){
		System.out.println("getPlayerList controller 폼 요청");
		List<Player> list = playerService.getPlayerList();
		
		return list;
		
	}
	// 플레이어 리스트 폼
	@PostMapping("/getPlayerListByPage")
	public List<Player> getPlayerListByPage(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "searchWord", required = false) String searchWord) {
		System.out.println("getPlayerListByPage controller 폼 요청");
		System.out.println("currentPage: " + currentPage); // 현 페이지수
		System.out.println("SearchWord: " + searchWord);

		int rowPerPage = 10; // 페이지당 보여줄 갯수

		List<Player> list = playerService.getPlayerListByPage(currentPage, rowPerPage, searchWord);
		System.out.println("getPlayerList controller list :" + list);
		return list;
	}
	
	// 카운트 출력
	@PostMapping("/getPlayerListCount")
	public int getPlayerListCount(@RequestParam(value = "searchWord", required = false) String searchWord) {
		Page page = new Page();
		page.setSearchWord(searchWord);
		int row = playerService.selectPlayerCount(page);
		return row;
	}
	/*
	 * @PostMapping("/addPlayerPosition") public int
	 * addPlayerPosition(@RequestParam(value = "playerNo") int playerNo ,
	 * 
	 * @RequestParam(value = "positionNo") int positionNo) {
	 * System.out.println("선수 포지션 입력 매개변수 값 : positionNo , playerNo :" + positionNo
	 * +"/"+playerNo);
	 * 
	 * System.out.println("playerNo 셋팅 값 : "+playerNo);
	 * 
	 * PlayerPosition playerPosition = new PlayerPosition();
	 * 
	 * playerPosition.setPlayerNo(playerNo);
	 * playerPosition.setPositionNo(positionNo);
	 * 
	 * int row = playerservice.addPlayerPosition(playerPosition);
	 * 
	 * return row; }
	 */
}

package com.epl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.PlayerMapper;
import com.epl.service.interfaces.PlayerService;
import com.epl.vo.Page;
import com.epl.vo.Player;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerMapper playerMapper;

	// 플레이어 추가
	@Override
	public int addPlayer(Player player) {
		System.out.println("player service 요청");
		int row = playerMapper.insertPlayer(player);
		return row;
	}
	
	
	// 플레이어의 번호 가져오기
	@Override
	public Player getPlayerOne(int playerNo) { // player 안에 no 를 셋팅
		System.out.println("getPlayerNo service 요청");
		Player getPlayer = playerMapper.selectPlayeOne(playerNo);
		return getPlayer;
	}

	// 플레이어 리스트 가져오기
	@Override
	public List<Player> getPlayerList() {
		System.out.println("getPlayerList service 요청");

		List<Player> list = playerMapper.selectPlayerList();
		System.out.println("getPlayerList service list :" + list);
		return list;
	}

	// 플레이어 리스트 페이지별 가져오기
	@Override
	public List<Player> getPlayerListByPage(int currentPage, int rowPerPage, String searchWord) {
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage - 1) * rowPerPage);
		page.setSearchWord(searchWord);

		List<Player> list = playerMapper.selectPlayerListByPage(page);

		return list;
	}
	// 선수 수 가져오기
	@Override
	public int getPlayerCount(Page page) {
		int totalRowCount = playerMapper.selectPlayerCount(page);
		return totalRowCount;
	}
	
	// 플레이어 수정
	@Override
	public int modifyPlayer(Player player) {
		int row = playerMapper.updatePlayer(player);
		return row;
	}
}

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

	/*
	 * // 플레이어의 포지션 지정하기
	 * 
	 * @Override public int addPlayerPosition(PlayerPosition playerPosition) {
	 * System.out.println("addPlayerPosition service 요청"); int row =
	 * playerMapper.insertPlayerPosition(playerPosition); System.out.println(row +
	 * "행 입력  실행 완료"); return row; }
	 */
	// 플레이어의 번호 가져오기
	@Override
	public int getPlayerNo(Player player) {
		System.out.println("getPlayerNo service 요청");
		int playerNo = playerMapper.selectPlayerNo(player);
		return playerNo;
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
	public int selectPlayerCount(Page page) {
		int totalRowCount = playerMapper.selectPlayerCount(page);
		return totalRowCount;
	}
}

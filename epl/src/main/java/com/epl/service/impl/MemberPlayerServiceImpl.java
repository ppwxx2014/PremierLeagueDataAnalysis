package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.MemberPlayerMapper;
import com.epl.service.interfaces.MemberplayerService;
import com.epl.vo.Page;
import com.epl.vo.Player;
import com.epl.vo.PlayerAppearance;
import com.epl.vo.PlayerContract;

@Service
@Transactional
public class MemberPlayerServiceImpl implements MemberplayerService {
	@Autowired MemberPlayerMapper memberPlayerMapper;
	
	@Override
	public List<Player> getMemberPlayerList(int currentPage, int rowPerPage, String searchWord) {
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage - 1) * rowPerPage);
		page.setSearchWord(searchWord);

		List<Player> list = memberPlayerMapper.selectMemberPlayerList(page);

		return list;
	}
	@Override
	public Player getMemberPlayerOne(int playerNo) {
		Player getPlayer = memberPlayerMapper.selectMemberPlayerOne(playerNo);
		System.out.println("getPlayer:"+getPlayer);
		return getPlayer;
	}
	@Override
	public PlayerContract getMemberPlayerInfo(int playerNo) {
		PlayerContract playercontract = memberPlayerMapper.selectMemberPlayerInfo(playerNo);
		System.out.println(playerNo);
		System.out.println("playercontract:"+playercontract);
		return playercontract;
	}
	@Override
	public PlayerAppearance getMemberPlayerAppearances(int playerNo) {
		PlayerAppearance playerAppearance = memberPlayerMapper.selectMemberPlayerAppearances(playerNo);
		System.out.println("playerAppearance:"+playerAppearance);
		return playerAppearance;
	}
}

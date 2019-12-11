package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.Player;
import com.epl.vo.PlayerContract;

public interface MemberplayerService {
	public List<Player> getMemberPlayerList(int currentPage, int rowPerPage, String searchWord);
	
	public Player getMemberPlayerOne(int playerNo);
	
	public PlayerContract getMemberPlayerInfo(int playerNo);
}

package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.Page;
import com.epl.vo.Player;

public interface PlayerService {
	public int addPlayer(Player player);

	public int getPlayerNo(Player player);

	public List<Player> getPlayerList();

	public List<Player> getPlayerListByPage(int currentPage, int rowPerPage, String searchWord);

	public int getPlayerCount(Page page);
	
	public int modifyPlayer(Player player);
}

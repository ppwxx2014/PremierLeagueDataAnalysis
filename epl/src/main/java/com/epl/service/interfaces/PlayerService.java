package com.epl.service.interfaces;

import java.util.List;
import java.util.Map;

import com.epl.vo.Player;

public interface PlayerService {
	public int addPlayer(Player player);

	public int getPlayerNo(Player player);

	public List<Player> getPlayerList();

	public Map<String, Object> getPlayerListByPage(int currentPage, int rowPerPage, String searchWord);
}

package com.epl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Page;
import com.epl.vo.Player;

@Mapper
public interface PlayerMapper {
	public int insertPlayer(Player player);

	public int selectPlayerNo(Player player);

	public List<Player> selectPlayerList();

	// public int insertPlayerPosition(PlayerPosition playerPosition);

	public ArrayList<Player> selectPlayerListByPage(Page page);

	public int selectPlayerCount(Page page);
}

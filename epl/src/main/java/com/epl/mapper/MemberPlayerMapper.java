package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Page;
import com.epl.vo.Player;
import com.epl.vo.PlayerAppearance;
import com.epl.vo.PlayerContract;

@Mapper
public interface MemberPlayerMapper {
	public List<Player> selectMemberPlayerList(Page page);
	
	public Player selectMemberPlayerOne(int playerNo);
	
	public PlayerContract selectMemberPlayerInfo(int playerNo);
	
	public PlayerAppearance selectMemberPlayerAppearances(int playerNo);
	
}

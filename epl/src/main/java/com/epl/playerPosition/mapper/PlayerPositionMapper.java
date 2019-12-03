package com.epl.playerPosition.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.PlayerPosition;

@Mapper
public interface PlayerPositionMapper {
	public int insertPlayerPosition(PlayerPosition playerPosition);
}

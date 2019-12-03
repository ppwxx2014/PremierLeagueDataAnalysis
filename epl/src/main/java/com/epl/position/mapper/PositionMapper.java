package com.epl.position.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Position;

@Mapper
public interface PositionMapper {
	public int selectPositionNo(Position position);
}

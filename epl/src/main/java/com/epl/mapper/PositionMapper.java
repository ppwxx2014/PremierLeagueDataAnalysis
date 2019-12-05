package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Position;

@Mapper
public interface PositionMapper {
	public List<Position> selectPositionList();
}

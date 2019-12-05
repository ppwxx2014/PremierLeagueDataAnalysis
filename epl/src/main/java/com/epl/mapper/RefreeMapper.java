package com.epl.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Refree;

@Mapper
public interface RefreeMapper {
	public int insertRefree(Refree refree);
}

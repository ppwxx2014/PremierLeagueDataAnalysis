package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Team;

@Mapper
public interface UserTeamMapper {
	public List<Team> selectUserTeamList();
}

package com.epl.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.CoachContract;

@Mapper
public interface CoachContractMapper {
	public int insertCoachContract(CoachContract coachContract);
}

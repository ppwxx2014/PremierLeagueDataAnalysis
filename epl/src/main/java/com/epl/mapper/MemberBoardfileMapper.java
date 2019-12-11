package com.epl.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MemberBoardfile;

@Mapper
public interface MemberBoardfileMapper {
	int insertMemberBoardfile(MemberBoardfile memberBoardfile);
	MemberBoardfile selectMemberBoardfileOne(int boardNo);
	int deleteMemberBoardfile(int boardNo);
}

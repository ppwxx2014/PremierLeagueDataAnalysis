package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MemberBoardfile;

@Mapper
public interface MemberBoardfileMapper {
	int insertMemberBoardfile(MemberBoardfile memberBoardfile);
	List<MemberBoardfile> selectMemberBoardfileOne(int boardNo);
	int deleteMemberBoardfile(int boardNo);
}

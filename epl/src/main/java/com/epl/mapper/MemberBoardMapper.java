package com.epl.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardForm;
import com.epl.vo.Page;

@Mapper
public interface MemberBoardMapper {
	int updateMemberBoard(MemberBoard memberBoard);
	
	int deleteMemberBoard(MemberBoard memberBoard);
	
	MemberBoard selectMemberBoardOne(int boardNo);
	
	int insertMemberBoard(MemberBoardForm memberBoardForm);

	ArrayList<MemberBoard> selectMemberBoardList(Page page);
	
	int selectMemberBoardCount(Page page);
	
	int check(MemberBoard memberBoard);
}

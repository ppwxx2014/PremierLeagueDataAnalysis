package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;

@Mapper
public interface AdminBoardManagementMapper {
	List<MemberBoard> selectAdminBoardList(String category);
	MemberBoard selectAdminBoardOne(int boardNo);
	List<MemberBoardComment> selectAdminBoardComment(int boardNo);
	int deleteAdminBoardComment(int commentNo);
	int deleteAdminBoardFile(int boardNo);
	int deleteAdminBoardCommentAll(int boardNo);
	int deleteAdminBoard(int boardNo);
}

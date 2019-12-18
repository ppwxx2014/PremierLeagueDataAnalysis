package com.epl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;
import com.epl.vo.Notice;
import com.epl.vo.Page;

@Mapper
public interface AdminBoardManagementMapper {
	List<MemberBoard> selectAdminBoardList(String category);
	MemberBoard selectAdminBoardOne(int boardNo);
	List<MemberBoardComment> selectAdminBoardComment(int boardNo);
	int deleteAdminBoardComment(int commentNo);
	int deleteAdminBoardFile(int boardNo);
	int deleteAdminBoardCommentAll(int boardNo);
	int deleteAdminBoard(int boardNo);
	
	int insertNotice(Notice notice);
	List<Notice> selectNoticeList(Page page);
	Notice selectNoticeOne(int noticeNo);
	int deleteNotice(Notice notice);
	int updateNotice(Notice notice);
	int selectNoticeCount(Page page);
	
	ArrayList<MemberBoard> selectAdminBoardListByPage(Page page);
	int selectAdminBoardCount(Page page);
}

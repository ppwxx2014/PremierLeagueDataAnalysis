package com.epl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;
import com.epl.vo.Notice;
import com.epl.vo.Page;
import com.epl.vo.PageByCategory;

@Mapper
public interface MemberBoardMapper {
	
	// 게시판 글에 관한 맵퍼
	int updateMemberBoard(MemberBoard memberBoard);
	
	int deleteMemberBoard(MemberBoard memberBoard);
	
	MemberBoard selectMemberBoardOne(int boardNo);
	
	int insertMemberBoard(MemberBoard memberBoard);

	ArrayList<MemberBoard> selectMemberBoardList(PageByCategory pageByCategory);
	
	int selectMemberBoardCount(PageByCategory pageByCategory);
	
	
	// 게시판 댓글에 관한 맵퍼
	int insertComment(MemberBoardComment memberBoardComment);
	
	List<MemberBoardComment> selectCommentList(int boardNo);
	
	int deleteComment(MemberBoardComment memberBoardComment);
	
	int deleteCommentAll(int boardNo);
	// 게시판 댓글 맵퍼 끝
	
	int check(MemberBoard memberBoard);
	
	List<String> selectBoardCategory();
	
	// 공지사항 보기
	List<Notice> selectNoticeList(Notice notice);
	
	// 공지사항 상세 정보
	Notice selectNoticeOne(int noticeNo);
}

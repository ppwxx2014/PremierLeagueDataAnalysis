package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;
import com.epl.vo.MemberBoardForm;
import com.epl.vo.Page;
import com.epl.vo.PageByCategory;

public interface MemberBoardService {
	void modifyBoard(MemberBoardForm memberBoardForm);
	
	int addBoard(MemberBoardForm memberBoardForm);
		
	List<MemberBoard> getBoardList(int currentPage, int rowPerPage, String searchWord, String category);
	
	MemberBoard getBoardOne(int boardNo);
	
	int removeBoard(MemberBoard memberBoard);
	
	int MemberBoardCount(PageByCategory pageByCategory);
	
	
	// 댓글 입력 인터페이스
	int addMemberBoardComment(MemberBoardComment memberBoardComment);
	
	// 댓글 리스트 출력
	List<MemberBoardComment> getCommentList(int boardNo);
	
	// 댓글 삭제
	int removeComment(MemberBoardComment memberBoardComment);
	
	//카테고리 리스트
	List<String> getBoardCategory();
	
}

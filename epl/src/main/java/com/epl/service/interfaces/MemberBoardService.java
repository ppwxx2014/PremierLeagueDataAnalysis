package com.epl.service.interfaces;

import java.util.List;
import java.util.Map;

import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardForm;
import com.epl.vo.Page;

public interface MemberBoardService {
	void modifyBoard(MemberBoardForm memberBoardForm);
	
	int addBoard(MemberBoardForm memberBoardForm);
		
	List<MemberBoard> getBoardList(int currentPage, int rowPerPage, String searchWord);
	
	MemberBoard getBoardOne(int boardNo);
	
	int removeBoard(MemberBoard memberBoard);
	
	int MemberBoardCount(Page page);
}

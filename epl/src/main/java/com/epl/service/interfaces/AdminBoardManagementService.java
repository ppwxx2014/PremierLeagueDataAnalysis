package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;


public interface AdminBoardManagementService {
	public List<MemberBoard> getAdminBoardList(String category);

	public MemberBoard getAdminBoardOne(int boardNo);
	
	public List<MemberBoardComment> getAdminBoardComment(int boardNo);

	public int removeAdminBoardComment(int commentNo);
	
	public int removeAdminBoard(int boardNo);
}

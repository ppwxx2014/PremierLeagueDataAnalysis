package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;
import com.epl.vo.Notice;
import com.epl.vo.Page;


public interface AdminBoardManagementService {
	public List<MemberBoard> getAdminBoardList(String category);

	public MemberBoard getAdminBoardOne(int boardNo);
	
	public List<MemberBoardComment> getAdminBoardComment(int boardNo);

	public int removeAdminBoardComment(int commentNo);
	
	public int removeAdminBoard(int boardNo);
	
	public int addNotice(Notice notice);
	public int removeNotice(Notice notice);
	public int modifyNotice(Notice notice);
	public List<Notice> getNoticeList(int currentPage, int rowPerPage);
	int noticeCount(Page page);
	Notice getNoticeOne(int noticeNo);
}

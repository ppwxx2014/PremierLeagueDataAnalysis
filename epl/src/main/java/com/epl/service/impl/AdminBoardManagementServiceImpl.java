package com.epl.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.AdminBoardManagementMapper;
import com.epl.service.interfaces.AdminBoardManagementService;
import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;
import com.epl.vo.MemberBoardfile;
import com.epl.vo.Notice;
import com.epl.vo.Page;

@Service
@Transactional
public class AdminBoardManagementServiceImpl implements AdminBoardManagementService{
	@Autowired private AdminBoardManagementMapper adminBoardManagementMapper;
	
	@Override
	public List<MemberBoard> getAdminBoardList(String category) {
		List<MemberBoard> list = adminBoardManagementMapper.selectAdminBoardList(category);
		System.out.println("AdminBoardManagementServiceImpl:::getAdminBoardList:::" + list);
		return list;
	}
	@Override
	public MemberBoard getAdminBoardOne(int boardNo) {
		MemberBoard memberBoard = adminBoardManagementMapper.selectAdminBoardOne(boardNo);
		System.out.println("AdminBoardManagementServiceImpl:::getAdminBoardList:::" + memberBoard);
		return memberBoard;
	}
	@Override
	public List<MemberBoardComment> getAdminBoardComment(int boardNo) {
		List<MemberBoardComment> list = adminBoardManagementMapper.selectAdminBoardComment(boardNo);
		return list;
	}
	@Override
	public int removeAdminBoardComment(int commentNo) {
		int row = adminBoardManagementMapper.deleteAdminBoardComment(commentNo);
		return row;
	}
	@Override
	public int removeAdminBoard(int boardNo) {
		
		System.out.println(boardNo);
		
		
		
        
        int boardRow = 0;
        
		try {
			// 1. 댓글 삭제
			int commentRow = adminBoardManagementMapper.deleteAdminBoardCommentAll(boardNo);
			System.out.println("commentRow :" + commentRow);

			// 2. 파일 삭제
			int boardfileRow = adminBoardManagementMapper.deleteAdminBoardFile(boardNo);
			System.out.println("boardfileRow :" + boardfileRow);
			
			//file.delete(); // 파일삭제
			
			// 3. 글 삭제
			boardRow = adminBoardManagementMapper.deleteAdminBoard(boardNo);
			System.out.println("boardRow :" + boardRow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
        System.out.println("MemberBoardS ::: " + boardRow);
		return boardRow;
	}
	
	@Override
	public int addNotice(Notice notice) {
		int noticeRow = adminBoardManagementMapper.insertNotice(notice);
		System.out.println("noticeRow :" + noticeRow);
		return noticeRow;
	}
	
	@Override
	public List<Notice> getNoticeList(int currentPage, int rowPerPage) {
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage - 1) * rowPerPage);
		
		List<Notice> list = adminBoardManagementMapper.selectNoticeList(page);
		System.out.println("noticeList : " + list);
		return list;
	}
	
	@Override
	public Notice getNoticeOne(int noticeNo) {
		Notice notice = adminBoardManagementMapper.selectNoticeOne(noticeNo);
		System.out.println("noticeOne : " + notice);
		return notice;
	}
	
	@Override
	public int modifyNotice(Notice notice) {
		int row = adminBoardManagementMapper.updateNotice(notice);
		System.out.println("noticeRow : " + row);
		return row;
	}
	
	@Override
	public int noticeCount(Page page) {
		int row = adminBoardManagementMapper.selectNoticeCount(page);
		System.out.println("noticeRow : " + row);
		return row;
	}
	
	@Override
	public int removeNotice(Notice notice) {
		int row = adminBoardManagementMapper.deleteNotice(notice);
		System.out.println("noticeRow : " + row);
		return row;
	}
	
	@Override
	public List<MemberBoard> getAdminBoardListByPage(int currentPage, int rowPerPage, String searchWord) {
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage -1)*rowPerPage);
		page.setSearchWord(searchWord);
		
		List<MemberBoard> list = adminBoardManagementMapper.selectAdminBoardListByPage(page);
		
		return list;
	}
	
	@Override
	public int getAdminBoardCount(Page page) {
		int row = adminBoardManagementMapper.selectAdminBoardCount(page);
		System.out.println("countRow:"+row);
		return row;
	}
}





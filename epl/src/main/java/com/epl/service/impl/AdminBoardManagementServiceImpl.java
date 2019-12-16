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
		
		
		/*
		 * String filename = null; String extension = null;
		 * 
		 * List<MemberBoardfile> memberBoardfile =
		 * memberBoardfileMapper.selectMemberBoardfileOne(boardNo);
		 * 
		 * System.out.println(memberBoardfile);
		 * 
		 * for(MemberBoardfile file : memberBoardfile) { if(memberBoardfile != null) {
		 * file.setFilename(filename); file.setExtension(extension); } }
		 */
        
        //File file = new File("C:\\Temp\\files\\" + filename +"."+ extension);
        
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
}





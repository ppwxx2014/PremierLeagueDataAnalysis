package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.MemberBoardMapper;
import com.epl.mapper.MemberBoardfileMapper;
import com.epl.service.interfaces.MemberBoardService;
import com.epl.service.interfaces.MemberService;
import com.epl.vo.Member;
import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardForm;
import com.epl.vo.MemberBoardfile;
import com.epl.vo.Page;

@Service
@Transactional
public class MemberBoardServiceImpl implements MemberBoardService{
	@Autowired private MemberBoardfileMapper memberBoardfileMapper;
	@Autowired private MemberBoardMapper memberBoardMapper;
	
	@Override
	public int addBoard(MemberBoardForm memberBoardForm) {
		int row = memberBoardMapper.insertMemberBoard(memberBoardForm);
		System.out.println("memberBoard Service ::::" + row);
		return row;
	}
	
	@Override
	public List<MemberBoard> getBoardList(int currentPage, int rowPerPage, String searchWord) {
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage - 1) * rowPerPage);
		page.setSearchWord(searchWord);
		
		List<MemberBoard> list = memberBoardMapper.selectMemberBoardList(page);
		
		return list;
	}
	
	@Override
	public MemberBoard getBoardOne(int boardNo) {
		MemberBoard memberBoard = memberBoardMapper.selectMemberBoardOne(boardNo);
		
		MemberBoardfile memberBoardfile = memberBoardfileMapper.selectMemberBoardfileOne(boardNo);
		
		memberBoard.setMemberBoardfile(memberBoardfile);
		System.out.println("memberBoardSerivce: " + memberBoard);
		return memberBoard;
	}

	@Override
	public void modifyBoard(MemberBoardForm memberBoardForm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int removeBoard(MemberBoard memberBoard) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int MemberBoardCount(Page page) {
		int row = memberBoardMapper.selectMemberBoardCount(page);
		System.out.println("row : " + row);
		return row;
	}
	
}






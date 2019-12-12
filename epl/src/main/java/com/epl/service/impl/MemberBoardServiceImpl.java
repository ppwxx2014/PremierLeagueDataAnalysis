package com.epl.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.epl.mapper.MemberBoardMapper;
import com.epl.mapper.MemberBoardfileMapper;
import com.epl.service.interfaces.MemberBoardService;
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
		
		// 1. MemberBoard
		MemberBoard memberBoard = new MemberBoard();
		memberBoard.setBoardTitle(memberBoardForm.getBoardTitle());
		memberBoard.setBoardContent(memberBoardForm.getBoardContent());
		memberBoard.setBoardUser(memberBoardForm.getBoardUser());
		
		System.out.println("memberBoardNo : " + memberBoard.getBoardNo()); // 0
		
		// memberBoard 내용 insert
		memberBoardMapper.insertMemberBoard(memberBoard);
		System.out.println("memberBoard insert 작업 후" + memberBoard); // boardNo 넘어옴
		
		System.out.println(memberBoardForm.getBoardfile());
		
		List<MultipartFile> mf = memberBoardForm.getBoardfile();
		
		List<MemberBoardfile> mbf = new ArrayList<MemberBoardfile>();
		
		int row = 0;
		
		for(MultipartFile m : mf) {
			String contentType = m.getContentType();
			String originName = m.getOriginalFilename();
			long size = m.getSize();
			String extension = originName.substring(originName.lastIndexOf(".") + 1); // 확장자 구하기
			String filename = UUID.randomUUID().toString().replace("-", "")+"."; // URL
			
			System.out.println("contentType"+ contentType);
			System.out.println("originName"+originName);
			System.out.println("size" +size);
			System.out.println("extension" +extension);
			System.out.println("filename" + filename);
			
			MemberBoardfile memberBoardfile = new MemberBoardfile();
			memberBoardfile.setBoardNo(memberBoard.getBoardNo());
			memberBoardfile.setContentType(contentType);
			memberBoardfile.setOriginName(originName);
			memberBoardfile.setSize(size);
			memberBoardfile.setExtension(extension);
			memberBoardfile.setFilename(filename);
			mbf.add(memberBoardfile);
			
			row = memberBoardfileMapper.insertMemberBoardfile(memberBoardfile);
			
			/*
			File file = new File("D:\\OffTheBall_project\\maven.1575882707047\\epl\\src\\main\\webapp\\upload\\" + filename + extension);
			// 파일로 저장
			try {
				m.transferTo( file );
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("memberBoardNo : " + memberBoard.getBoardNo());
				throw new RuntimeException(); // 최상위 예외 
			}
			*/
			
		}

		System.out.println("파일 업로드 : " + row);
		// 파일명 그대로 originName
		// 랜덤문자열: UUID.randomUUID().toString()
		// 랜덤문자열 + originName: UUID.randomUUID().toString() + originName;
		// 랜덤문자열 + 타입: UUID.randomUUID().toString()+"."+extension; 
		// 랜덤문자열의 - 뺴기: UUID.randomUUID().toString().replace("-", "")+"."+extension;
		
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
		
		List<MemberBoardfile> memberBoardfile = memberBoardfileMapper.selectMemberBoardfileOne(boardNo);
		
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






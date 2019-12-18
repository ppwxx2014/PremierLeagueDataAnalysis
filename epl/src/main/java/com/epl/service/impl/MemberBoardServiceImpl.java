package com.epl.service.impl;

import java.io.File;
import java.io.FileOutputStream;
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
import com.epl.vo.MemberBoardComment;
import com.epl.vo.MemberBoardForm;
import com.epl.vo.MemberBoardfile;
import com.epl.vo.PageByCategory;

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
		memberBoard.setBoardCategory(memberBoardForm.getBoardCategory());
		
		System.out.println("memberBoardNo : " + memberBoard.getBoardNo()); // 0
		
		// memberBoard 내용 insert
		memberBoardMapper.insertMemberBoard(memberBoard);
		System.out.println("memberBoard insert 작업 후" + memberBoard); // boardNo 넘어옴
		
		System.out.println(memberBoardForm.getBoardfile());
		
		List<MultipartFile> mf = memberBoardForm.getBoardfile();
		System.out.println("memberBoardService" + mf);
		
		List<MemberBoardfile> mbf = new ArrayList<MemberBoardfile>();
		
		int row = 0;
		
		// 파일이 있을 경우에만
		boolean result = false;
		if(mf != null) {
			for(MultipartFile m : mf) {
				String contentType = m.getContentType();
				String originName = m.getOriginalFilename();
				long size = m.getSize();
				String extension = originName.substring(originName.lastIndexOf(".") + 1); // 확장자 구하기
				String filename = UUID.randomUUID().toString().replace("-", "")+"."+extension; // URL
				
				System.out.println("contentType : "+ contentType);
				System.out.println("originName : "+originName);
				System.out.println("size : " +size);
				System.out.println("extension : " +extension);
				System.out.println("filename : " + filename);
				
				MemberBoardfile memberBoardfile = new MemberBoardfile();
				memberBoardfile.setBoardNo(memberBoard.getBoardNo());
				memberBoardfile.setContentType(contentType);
				memberBoardfile.setOriginName(originName);
				memberBoardfile.setSize(size);
				memberBoardfile.setExtension(extension);
				memberBoardfile.setFilename(filename);
				mbf.add(memberBoardfile);
				
				System.out.println(memberBoardfile.toString());
				
				try {
					row = memberBoardfileMapper.insertMemberBoardfile(memberBoardfile);
					
					// MultipartFile을 File로 변환
					File convertFile = new File(filename);
					convertFile.createNewFile();
					FileOutputStream fos = new FileOutputStream(convertFile);
					fos.write(mf.get(row).getBytes());
					fos.close();
					
					// 업로드 디렉토리
					String dir = "/www/board/";
					// CDN에 업로드 시작
					System.out.println("Upload Start");
					FTPService ftpUploader = new FTPService();
					// FTP 연결
					ftpUploader.connectFTP(dir);
					// 파일 업로드
					result = ftpUploader.uploadFile(convertFile, filename);
					// FTP 연결 해제
					ftpUploader.disconnect();
					System.out.println("Done");
				} catch(Exception e) {
					e.printStackTrace();
					// 파일을 저장할때 예외가 나면 rollback 시키기 위해서 강제로 런타임 예외 발생시킴.
					throw new RuntimeException();
				}
				
			}
			if(result) {
				System.out.println("업로드 성공");
			} else {
				System.out.println("업로드 실패");
			}
		}
		
		
		System.out.println("파일 업로드 : " + row);
		// 파일명 그대로 originName
		// 랜덤문자열: UUID.randomUUID().toString()
		// 랜덤문자열 + originName: UUID.randomUUID().toString() + originName;
		// 랜덤문자열 + 타입: UUID.randomUUID().toString()+"."+extension; 
		// 랜덤문자열의 - 뺴기: UUID.randomUUID().toString().replace("-", "")+"."+extension;
		
		return row;
	}
	
	// 게시판 페이징 리스트
	@Override
	public List<MemberBoard> getBoardList(int currentPage, int rowPerPage, String searchWord, String category) {
		PageByCategory pageByCategory = new PageByCategory();
		pageByCategory.setRowPerPage(rowPerPage);
		pageByCategory.setBeginRow((currentPage - 1) * rowPerPage);
		pageByCategory.setSearchWord(searchWord);
		pageByCategory.setCategory(category);
		List<MemberBoard> list = memberBoardMapper.selectMemberBoardList(pageByCategory);
		
		return list;
	}
	
	// 게시판 상세보기
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
		
		// 1. 기존 정보 수정
		MemberBoard beforeMemberBoard = new MemberBoard();
		beforeMemberBoard.setBoardNo(memberBoardForm.getBoardNo());
		beforeMemberBoard.setBoardContent(memberBoardForm.getBoardContent());
		beforeMemberBoard.setBoardTitle(memberBoardForm.getBoardTitle());
		beforeMemberBoard.setBoardUser(memberBoardForm.getBoardUser());
		memberBoardMapper.updateMemberBoard(beforeMemberBoard);
		
		int boardNo = beforeMemberBoard.getBoardNo();
		
		System.out.println("modifyBoardNo: " +  boardNo);
		List<MemberBoardfile> beforeBoardfile = memberBoardfileMapper.selectMemberBoardfileOne(boardNo);
		System.out.println("modifyBeforeBoardFile" + beforeBoardfile);
		
		String beforeFilename = null; // 삭제할 파일 이름
        String beforeExtension = null;
        
        for(MemberBoardfile file : beforeBoardfile) { // 파일 있으면 파일 저장
    		if(beforeBoardfile != null) {
        		file.setFilename(beforeFilename);
        		file.setExtension(beforeExtension);
    		}
        }
        
        File beforeFile = new File("C:\\Temp\\files\\" + beforeFilename +"."+ beforeExtension);
        beforeFile.delete(); // 경로에있는 파일 삭제
        memberBoardfileMapper.deleteMemberBoardfile(boardNo); // 디비 파일 삭제
        
        // 파일저장
        System.out.println(memberBoardForm.getBoardfile());
		
		List<MultipartFile> mf = memberBoardForm.getBoardfile();
		System.out.println("memberBoardService" + mf);
		
		List<MemberBoardfile> mbf = new ArrayList<MemberBoardfile>();
		
		int row = 0;
		
		// 파일이 있을 경우에만
		if(mf != null) {
			for(MultipartFile m : mf) {
				String contentType = m.getContentType();
				String originName = m.getOriginalFilename();
				long size = m.getSize();
				String extension = originName.substring(originName.lastIndexOf(".") + 1); // 확장자 구하기
				String filename = UUID.randomUUID().toString().replace("-", ""); // URL
				
				System.out.println("contentType"+ contentType);
				System.out.println("originName"+originName);
				System.out.println("size" +size);
				System.out.println("extension" +extension);
				System.out.println("filename" + filename);
				
				MemberBoardfile memberBoardfile = new MemberBoardfile();
				memberBoardfile.setBoardNo(memberBoardForm.getBoardNo());
				memberBoardfile.setContentType(contentType);
				memberBoardfile.setOriginName(originName);
				memberBoardfile.setSize(size);
				memberBoardfile.setExtension(extension);
				memberBoardfile.setFilename(filename);
				mbf.add(memberBoardfile);
				
				row = memberBoardfileMapper.insertMemberBoardfile(memberBoardfile);
				
				
				/*
				 * // 파일로 저장 try { m.transferTo( file ); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace();
				 * System.out.println("memberBoardNo : " + memberBoardForm.getBoardNo()); throw
				 * new RuntimeException(); // 최상위 예외 }
				 */
			}
		}
		System.out.println("파일 업로드 : " + row);
	}

	@Override
	public int removeBoard(MemberBoard memberBoard) {
		System.out.println("sdafkldsfjksadl;fjsdklfjsdklfjsdklfjsdlkfjdskfjsdklfdsj");
		int boardNo = memberBoard.getBoardNo();
		System.out.println(boardNo);
		
		int check = memberBoardMapper.check(memberBoard);
		System.out.println(check);
		
		String filename = null;
        String extension = null;
        
        List<MemberBoardfile> memberBoardfile = memberBoardfileMapper.selectMemberBoardfileOne(boardNo);
        
        System.out.println(memberBoardfile);
        
		
        
        
        int boardRow = 0;
        
        if (check == 1) {
			try {
				// 1. 댓글 삭제
				int commentRow = memberBoardMapper.deleteCommentAll(boardNo);
				System.out.println("commentRow :" + commentRow);

				// 2. db에 저장된 파일 정보 삭제
				int boardfileRow = memberBoardfileMapper.deleteMemberBoardfile(boardNo);
				System.out.println("boardfileRow :" + boardfileRow);
				
				// 2-1 카페24 파일 삭제
				if (memberBoardfile != null) { 
					for (MemberBoardfile file : memberBoardfile) {
						file.setFilename(filename);
						file.setExtension(extension);
					}
				}
				
				// 3. 글 삭제
				boardRow = memberBoardMapper.deleteMemberBoard(memberBoard);
				System.out.println("boardRow :" + boardRow);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
        System.out.println("MemberBoardS ::: " + boardRow);
		return boardRow;
	}
	
	@Override
	public int MemberBoardCount(PageByCategory pageByCategory) {
		int row = memberBoardMapper.selectMemberBoardCount(pageByCategory);
		System.out.println("row : " + row);
		return row;
	}
	
	// 댓글 입력
	@Override
	public int addMemberBoardComment(MemberBoardComment memberBoardComment) {
		int row = memberBoardMapper.insertComment(memberBoardComment);
		System.out.println("row : " + row);
		return row;
	}
	
	// 댓글 리스트
	@Override
	public List<MemberBoardComment> getCommentList(int boardNo) {
		return memberBoardMapper.selectCommentList(boardNo);
	}
	
	// 댓글 삭제
	@Override
	public int removeComment(MemberBoardComment memberBoardComment) {
		int row = memberBoardMapper.deleteComment(memberBoardComment);
		System.out.println("row : " + row);
		return row;
	}
	@Override
	public List<String> getBoardCategory() {
		List<String> list = memberBoardMapper.selectBoardCategory();
		return list;
	}
}






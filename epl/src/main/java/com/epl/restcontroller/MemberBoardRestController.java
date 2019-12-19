package com.epl.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MemberBoardService;
import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;
import com.epl.vo.MemberBoardForm;
import com.epl.vo.Notice;
import com.epl.vo.PageByCategory;

@RestController
public class MemberBoardRestController {
	@Autowired private MemberBoardService memberBoardService;
	
	
	// 게시판 추가
	@PostMapping("/addMemberBoard")
	public int addMemberBoard(MemberBoardForm memberBoardForm) {
		System.out.println("addMemberBoard C:::::::" + memberBoardForm);
		
		int row = memberBoardService.addBoard(memberBoardForm);
		System.out.println(row);
		return row;
	}
	
	// 게시글 삭제
	@PostMapping("/removeMemberBoard")
	public int removeMemberBoard(MemberBoard memberBoard) {
		
		String memberId = memberBoard.getBoardUser();
		int boardNo = memberBoard.getBoardNo();
		
		int row = 0;
		System.out.println(memberId);
		System.out.println(boardNo);
		// 글 쓰기전 세션 검사
		if(memberId != null) {
			row = memberBoardService.removeBoard(memberBoard);
		}
		
		return row;
	}
	
	// 게시글 수정
	@PostMapping("/modifyMemberBoard")
	public int modifyMemberBoard(MemberBoardForm memberBoardForm) {
		
		String memberId = memberBoardForm.getBoardUser();
		System.out.println(memberBoardForm);
		int row = 0;
		// 글 쓰기전 세션 검사
		if(memberId == null) {
			return 0;
		} else {
			memberBoardService.modifyBoard(memberBoardForm);
			row = 1;
		}
		return row;
	}
	
	// 댓글 추가
	@PostMapping("/addMemberBoardComment")
	public int addMemberBoardComment(HttpSession session, MemberBoardComment memberBoardComment) {
		String memberId = (String)session.getAttribute("memberId");
		System.out.println(memberId);
		int row = 0;
		System.out.println("addMemberBoardCommentC::::::" + memberBoardComment);
		
		// 글 쓰기전 세션 검사
		if(memberId != null) {
			row = memberBoardService.addMemberBoardComment(memberBoardComment);
		}
		System.out.println(row);
		return row;
	}
	
	// 댓글 리스트
	@PostMapping("/getCommentList")
	public List<MemberBoardComment> getCommentList(@RequestParam(value = "boardNo") int boardNo) {
		System.out.println("getCommentListC");
		List<MemberBoardComment> list = memberBoardService.getCommentList(boardNo);
		//list.add(e)
		System.out.println(list);
		return list;
	}
	
	// 공지사항
	@PostMapping("/getMemberNoticeList")
	public List<Notice> getMemberNoticeList(Notice notice) {
		List<Notice> list = memberBoardService.getNoticeList(notice);
		System.out.println("list : " + list);
		return list;
	}
		
	
	@PostMapping("/removeComment")
	public int removeComment(MemberBoardComment memberBoardComment) {
		System.out.println(memberBoardComment);
		int row = memberBoardService.removeComment(memberBoardComment);
		System.out.println("row : " + row);
		return row;
	}
	
	// 게시판 리스트(페이징)
	@PostMapping("/getMemberBoardByPage")
	public List<MemberBoard> getMemberBoardByPage(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "searchWord", required = false) String searchWord, @RequestParam(required = false) String category) {
		System.out.println("getMemberBoardByPage C");
		System.out.println("currentPage: " + currentPage); // 현 페이지수
		System.out.println("SearchWord: " + searchWord);
		System.out.println("category: " + category);

		int rowPerPage = 10; // 페이지당 보여줄 갯수

		List<MemberBoard> list = memberBoardService.getBoardList(currentPage, rowPerPage, searchWord, category);
		System.out.println("list : " + list);
		return list;
	}
	
	// 카운트 출력
	@PostMapping("/getMemberBoardListCount")
	public int getPlayerListCount(@RequestParam(value = "searchWord", required = false) String searchWord, @RequestParam(required = false) String category) {
		PageByCategory pageByCategory = new PageByCategory();
		pageByCategory.setSearchWord(searchWord);
		pageByCategory.setCategory(category);
		int row = memberBoardService.MemberBoardCount(pageByCategory);
		System.out.println(row);
		return row;
	}
	
	// 게시판 상세보기
	@PostMapping("/getMemberBoardListOne")
	public MemberBoard getMemberTeamOne(HttpSession session,
										@RequestParam(value = "boardNo", required = true) int boardNo){
		System.out.println("::::::::::listOne Controller::::::::::::::::");
		System.out.println("boardNo: " + boardNo);
		MemberBoard memberBoard = memberBoardService.getBoardOne(boardNo);
		
		System.out.println("memberBoard : " + memberBoard);
		return memberBoard;
	}
	
	// 공지사항
	@PostMapping("/getMemberNoticeOne")
	public Notice getMemberNoticeNoe(@RequestParam(value = "noticeNo", required = true) int noticeNo) {
		
		System.out.println("noticeNo : " + noticeNo);
		Notice notice = memberBoardService.getNoticeOne(noticeNo);
		System.out.println("notice : " + notice);
		return notice;
	}
		
		
	@PostMapping("/getBoardCategory")
	public List<String> getBoardCategory(){
		System.out.println("::::::::::getBoardCategory Controller::::::::::::::::");
		List<String> list = memberBoardService.getBoardCategory();
		
		System.out.println("list : " + list);
		return list;
	}
	
}













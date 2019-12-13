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
import com.epl.vo.Page;

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
	
	@PostMapping("/addMemberBoardComment")
	public int addMemberBoardComment(MemberBoardComment memberBoardComment) {
		System.out.println("addMemberBoardCommentC::::::" + memberBoardComment);
		int row = memberBoardService.addMemberBoardComment(memberBoardComment);
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
			@RequestParam(value = "searchWord", required = false) String searchWord) {
		System.out.println("getMemberBoardByPage C");
		System.out.println("currentPage: " + currentPage); // 현 페이지수
		System.out.println("SearchWord: " + searchWord);

		int rowPerPage = 10; // 페이지당 보여줄 갯수

		List<MemberBoard> list = memberBoardService.getBoardList(currentPage, rowPerPage, searchWord);
		System.out.println("list : " + list);
		return list;
	}
	
	// 카운트 출력
	@PostMapping("/getMemberBoardListCount")
	public int getPlayerListCount(@RequestParam(value = "searchWord", required = false) String searchWord) {
		Page page = new Page();
		page.setSearchWord(searchWord);
		int row = memberBoardService.MemberBoardCount(page);
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
	
}













package com.epl.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.epl.service.interfaces.MemberBoardService;
import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardForm;
import com.epl.vo.MemberBoardfile;
import com.epl.vo.Page;
import com.epl.vo.Player;
import com.epl.vo.Team;

@RestController
public class MemberBoardRestController {
	@Autowired private MemberBoardService memberBoardservice;
	
	// 게시판 추가
	@PostMapping("/addMemberBoard")
	public int addMemberBoard(MemberBoardForm memberBoardForm) {
		System.out.println("addMemberBoard C:::::::" + memberBoardForm);
		
		int row = memberBoardservice.addBoard(memberBoardForm);
		System.out.println(row);
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

		List<MemberBoard> list = memberBoardservice.getBoardList(currentPage, rowPerPage, searchWord);
		System.out.println("list : " + list);
		return list;
	}
	
	// 카운트 출력
	@PostMapping("/getMemberBoardListCount")
	public int getPlayerListCount(@RequestParam(value = "searchWord", required = false) String searchWord) {
		Page page = new Page();
		page.setSearchWord(searchWord);
		int row = memberBoardservice.MemberBoardCount(page);
		System.out.println(row);
		return row;
	}
	
	// 게시판 상세보기
	@PostMapping("/getMemberBoardListOne")
	public MemberBoard getMemberTeamOne(HttpSession session){
		System.out.println("::::::::::listOne Controller::::::::::::::::");
		int boardNo = (int) session.getAttribute("boardNo");
		System.out.println("boardNo: " + boardNo);
		MemberBoard memberBoard = memberBoardservice.getBoardOne(boardNo);
		
		System.out.println("memberBoard : " + memberBoard);
		return memberBoard;
	}
}













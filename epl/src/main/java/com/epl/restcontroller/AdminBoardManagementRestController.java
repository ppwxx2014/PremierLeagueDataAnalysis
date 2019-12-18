package com.epl.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.AdminBoardManagementService;
import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;
import com.epl.vo.MemberBoardForm;
import com.epl.vo.Notice;
import com.epl.vo.Page;

@RestController
public class AdminBoardManagementRestController {
	@Autowired
	private AdminBoardManagementService adminBoardManagementService;
	
	// 공지사항 추가
	@PostMapping("/addNotice")
	public int addNotice(Notice notice) {
		int row = adminBoardManagementService.addNotice(notice);
		System.out.println("addNotice notice: " + notice);
		return row;
	}
	
	// 공지사항 리스트(페이징)
	@PostMapping("/getNoticeList")
	public List<Notice> getNoticeList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		System.out.println("currentPage: " + currentPage); // 현 페이지수

		int rowPerPage = 10; // 페이지당 보여줄 갯수

		List<Notice> list = adminBoardManagementService.getNoticeList(currentPage, rowPerPage);
		System.out.println("list : " + list);
		return list;
	}
	
	// 카운트 출력
	@PostMapping("/getNoticeCount")
	public int getNoticeCount() {
		Page page = new Page();
		int row = adminBoardManagementService.noticeCount(page);
		System.out.println(row);
		return row;
	}
	
	// 공지사항 상세보기
	@PostMapping("/adminNoticeOne")
	public Notice getNoticeListOne(HttpSession session,
										@RequestParam(value = "noticeNo", required = true) int noticeNo) {
		System.out.println("::::::::::listOne Controller::::::::::::::::");
		System.out.println("noticeNo: " + noticeNo);
		Notice notice = adminBoardManagementService.getNoticeOne(noticeNo);
		
		System.out.println("notice : " + notice);
		return notice;
	}
	
	// 공지사항 삭제
	@PostMapping("/removeNotice")
	public int removeNotice(Notice notice) {
		
		System.out.println(notice);
		int row = adminBoardManagementService.removeNotice(notice);
		
		System.out.println("noticeRow :" + row);
		return row;
	
	}
	
	// 공지사항 수정
	@PostMapping("/modifyNotice")
	public int modifyNotice(Notice notice) {
		
		System.out.println(notice);
		int row = adminBoardManagementService.modifyNotice(notice);
		
		System.out.println("noticeRow :" + row);
		return row;
	}
	
	
	@PostMapping("/getBoardList")
	public List<MemberBoard> getBoardList(@RequestParam(required = false) String category){
		System.out.println("getBoardList category : "+category);
		List<MemberBoard> list = adminBoardManagementService.getAdminBoardList(category);
		System.out.println("getBoardList"+list);
		return list;
	}
	@PostMapping("/getBoardOne")
	public MemberBoard getBoardOne(@RequestParam(required = true) int boardNo){
		MemberBoard memberBoard = adminBoardManagementService.getAdminBoardOne(boardNo);
		System.out.println("getBoardOne memberBoard : "+memberBoard);
		return memberBoard;
	}
	@PostMapping("/getBoardComment")
	public List<MemberBoardComment> getBoardComment(@RequestParam(required = true) int boardNo){
		List<MemberBoardComment> memberBoardComment = adminBoardManagementService.getAdminBoardComment(boardNo);
		System.out.println("getBoardComment memberBoardComment : "+memberBoardComment);
		return memberBoardComment;
	}
	@PostMapping("/removeBoardComment")
	public int removeBoardComment(@RequestParam(required = true) int commentNo){
		int row = adminBoardManagementService.removeAdminBoardComment(commentNo);
		System.out.println("removeBoardComment is success : "+row);
		return row;
	}
	@PostMapping("/removeBoardAdmin")
	public int removeBoardAdmin(@RequestParam(required = true) int boardNo){
		int row = adminBoardManagementService.removeAdminBoard(boardNo);
		System.out.println("removeBoardComment is success : "+row);
		return row;
	}
	
	@PostMapping("/getBoardListByPage")
	public List<MemberBoard> getBoardListByPage(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
			@RequestParam(value = "searchWord",required = false) String searchWord){
		System.out.println("currentPage:"+currentPage);
		System.out.println("searchWord:"+searchWord);
		int rowPerPage = 10;
		List<MemberBoard> list = adminBoardManagementService.getAdminBoardListByPage(currentPage, rowPerPage, searchWord);
		System.out.println("getBoardListByPage list:"+list);
		return list;
	}
	@PostMapping("/getAdminBoardCount")
	public int getAdminBoardCount(@RequestParam(value = "searchWord",required = false) String searchWord) {
		Page page = new Page();
		page.setSearchWord(searchWord);
		int row = adminBoardManagementService.getAdminBoardCount(page);
		System.out.println("resRow:"+row);
		return row;
	}
	
}

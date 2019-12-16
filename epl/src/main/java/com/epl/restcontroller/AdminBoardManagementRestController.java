package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.AdminBoardManagementService;
import com.epl.vo.MemberBoard;
import com.epl.vo.MemberBoardComment;

@RestController
public class AdminBoardManagementRestController {
	@Autowired
	private AdminBoardManagementService adminBoardManagementService;
	
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
}

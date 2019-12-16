package com.epl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberBoardController {
	
	// 유저 게시판
	@GetMapping("/memberBoard")
	public String memberBoard() {
		return "member/memberBoard";
	}
	
	// 게시판 글 입력
	@GetMapping("/addMemberBoard")
	public String addMemberBoard() {
		return "member/addMemberBoard";
	}
	
	// 게시글 목록
	@GetMapping("/getMemberBoardList")
	public String getMemberBoardList() {
		return "member/getMemberBoardList";
	}
	
	// 게시글 상세보기
	@GetMapping("/getMemberBoardListOne")
	public String getMemberBoardListOne(@RequestParam(value = "boardNo", required = true) int boardNo, HttpSession session){
		System.out.println("boardNo");
		return "member/getMemberBoardListOne";	
	}
	
	// 게시글 상세보기
	@GetMapping("/modifyMemberBoard")
	public String modifyBoard(@RequestParam(value = "boardNo", required = true) int boardNo, HttpSession session){
		System.out.println("boardNo");
		return "member/modifyMemberBoard";	
	}
}










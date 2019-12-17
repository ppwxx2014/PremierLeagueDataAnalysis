package com.epl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epl.vo.Admin;

@Controller
public class AdminBoardManagementController {
	
	@GetMapping("/adminNotice")
	public String adminAddNotice(HttpSession session) {
		/*
		 * if (session.getAttribute("loginState") == null) { return "login"; }
		 */
		System.out.println("adminAddNotice page move");
		return "adminboard/adminNotice";
	}
	
	// 게시글 상세보기
	@GetMapping("/adminNoticeOne")
	public String getMemberBoardListOne(@RequestParam(value = "noticeNo", required = true) int noticeNo, HttpSession session) {
		/*
		 * if (session.getAttribute("loginState") == null) { return "login"; }
		 */
		System.out.println("boardNo");
		return "adminboard/adminNoticeOne";	
	}
	
	@GetMapping("/adminBoardAllCategory")
	public String adminBoardAllCategody(HttpSession session) {
		if (session.getAttribute("loginState") == null) {
			return "login";
		}
		System.out.println("adminBoardAllCategory page move");
		return "adminboard/adminBoardAllCategory";
	}
	@GetMapping("/adminBoardOne")
	public String adminBoardOne(@RequestParam(required = true) int boardNo, HttpSession session) {
		if (session.getAttribute("loginState") == null) {
			return "login";
		}
		System.out.println("adminBoardOne page move");
		return "adminboard/adminBoardOne";
	}
	@GetMapping("/adminCommnetDelete")
	public String adminCommnetDelete(@RequestParam(required = true) int commentNo, HttpSession session) {
		if (session.getAttribute("loginState") == null) {
			return "login";
		}
		System.out.println("adminCommnetDelete page move");
		return "adminboard/adminCommentDelete";
	}
	@GetMapping("/adminBoardDelete")
	public String adminBoardDelete(@RequestParam(required = true) int boardNo, HttpSession session) {
		if (session.getAttribute("loginState") == null) {
			return "login";
		}
		System.out.println("adminBoardDelete page move");
		return "adminboard/adminBoardDelete";
	}

	@GetMapping("/adminBoardList")
	public String adminBoardList(HttpSession session) {
		if (session.getAttribute("loginState") == null) {
			return "login";
		}
		System.out.println("adminBoardList page move");
		return "adminboard/adminBoardList";
	}
}

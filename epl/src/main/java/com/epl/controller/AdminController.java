package com.epl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epl.service.interfaces.AdminService;
import com.epl.vo.Admin;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@GetMapping("/addAdmin")
	public String addAdmin(HttpSession session, Model model) {

		Admin admin = (Admin) session.getAttribute("loginState");
		System.out.println(admin);
		model.addAttribute("admin", admin);

		return "addAdmin";
	}

	@PostMapping("/addAdmin")
	public String addAdmin(Admin admin) {

		System.out.println("addAdminC:::::::::::::::::::::::::::::");
		adminService.addAdmin(admin);

		return "redirect:/login";
	}

	@GetMapping("/adminIndex")
	public String index(HttpSession session, Model model) {
		Admin loginState = (Admin) session.getAttribute("loginState");
		/*
		 * if (session.getAttribute("loginState") == null) { return "login"; }
		 */
		model.addAttribute("loginState", loginState);
		return "adminIndex";
	}
	
	@GetMapping("/scheduler")
	public String scheduler(HttpSession session, Model model) {
		Admin loginState = (Admin) session.getAttribute("loginState");
		/*
		 * if (session.getAttribute("loginState") == null) { return "login"; }
		 */
		model.addAttribute("loginState", loginState);
		return "scheduler";
	}
	// 수정
	@GetMapping("/modifyAdmin")
	public String modifyAdmin(HttpSession session, Model model, Admin admin) {
		System.out.println("modifyAdmin 폼 요청");

		if (session.getAttribute("loginState") == null) {
			return "redirect:/login";
		}
		admin = (Admin) session.getAttribute("loginState");
		System.out.println("수정::::::::::::::::::::::::::::::::::" + admin);
		System.out.println("수정::::::::::::::::::::::::::::::::::" + session);
		model.addAttribute("admin", admin);
		return "modifyAdmin";
	}

	@PostMapping("/modifyAdmin")
	public String modifyAdmin(Admin admin, @RequestParam(value = "beforePw", required = true) String beforePw,
			HttpSession session) {
		System.out.println("업데이트 실행");
		System.out.println("modifyStudent controller param session :" + session); // 기존 어드민 값 id , pw
		System.out.println("modifyStudent controller param admin :" + admin);// 수정하고 싶은 어드민
		System.out.println("modifyStudent controller param beforePw :" + beforePw); // 기존 어드민 비밀번호 pw

		Admin loginAdmin = (Admin) session.getAttribute("loginState");// 기존 회원정보를 loginAdmin 객체에 저장

		if (loginAdmin.getAdminPw().equals(beforePw)) {
			int row = adminService.modifyAdmin(admin);
			System.out.println(row + "행 수정 완료");
		} else {
			System.out.println("비밀번호 틀림 ");
			session.invalidate();// 로그아웃
			return "redirect:/login";
		}
		return "redirect:/adminIndex";
	}

	@PostMapping("/modifyAdminPw")
	public String modifyAdminPw(HttpSession session, Model model, Admin admin) {
		// 1. 이메일 임시비밀번호 발송
		String adminEmail = admin.getAdminEmail();

		adminService.modifyAdminPw(adminEmail);

		model.addAttribute("adminEmail", adminEmail);

		// 2. 임시 비밀번호로 로그인 후 수정탭에서 비밀번호 수정
		return "redirect:/login";
	}

	@GetMapping("/modifyAdminPw")
	public String addMember() {
		return "modifyAdminPw";
	}
}

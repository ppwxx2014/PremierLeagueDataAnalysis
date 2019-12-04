package com.epl.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

	// 게시판 이동
	@GetMapping("/userBoard")	
	public String userBoard() {
		return "userBoard";
	}
	
	// :::::::::::::::::::::::::::: 여기부터 선수 카테고리 :::::::::::::::::::::::::::: //
	
	@GetMapping("/modifyPlayer")	
	public String modifyPlayer() {
		return "modifyPlayer";
	}
	
	@GetMapping("/playerContract")	
	public String playerContract() {
		return "playerContract	";
	}
	
	// :::::::::::::::::::::::::::: 여기부터 팀 카테고리 :::::::::::::::::::::::::::: //
	
	@GetMapping("/getTeam")	
	public String getTeam() {
		return "getTeam";
	}

	
	/*@GetMapping("/addTeamLeader")	
	public String addTeamLeader() {
		return "addTeamLeader";
	}*/
	
	
	@GetMapping("/changeTeam")	
	public String changeTeam() {
		return "changeTeam";
	}
	
	// :::::::::::::::::::::::::::: 여기부터 심판	 카테고리 :::::::::::::::::::::::::::: //
	
	@GetMapping("/getRefree")	
	public String getRefree() {
		return "getRefree";
	}
	
	// :::::::::::::::::::::::::::: 여기부터 경기 카테고리 :::::::::::::::::::::::::::: //
	
	@GetMapping("/addMatchSchedule")	
	public String addMatchSchedule() {
		return "addMatchSchedule";
	}
	
	@GetMapping("/getMatchSchedule")	
	public String getMatchSchedule() {
		return "getMatchSchedule";
	}	
	
	@GetMapping("/matchResult")	
	public String matchResult() {
		return "matchResult";
	}
	
	// :::::::::::::::::::::::::::: 여기부터 실시간 경기 카테고리 :::::::::::::::::::::::::::: //
	
	@GetMapping("/addLineUp")	
	public String addLineUp() {
		return "addLineUp";
	}
	
	@GetMapping("/addPlayerRecord")	
	public String addPlayerRecord() {
		return "addPlayerRecord";
	}
	
	@GetMapping("/addKepperRecord")	
	public String addKepperRecord() {
		return "addKepperRecord";
	}
	
	// :::::::::::::::::::::::::::: 여기부터 회원관리 카테고리 :::::::::::::::::::::::::::: //
	
	@GetMapping("/addNotice")	
	public String addNotice() {
		return "addNotice";
	}
	
	@GetMapping("/MembershipManagement")	
	public String MembershipManagement() {
		return "MembershipManagement";
	}
	
	// :::::::::::::::::::::::::::: topBar 관리자 설정 :::::::::::::::::::::::::::: //
	
	@GetMapping("/modifyManager")	
	public String modifyAdmin() {
		return "modifyAdmin";
	}
	
	@GetMapping("/managerLogout")	
	public String logout() {
		return "logout";
	}

	
	// :::::::::::::::::::::::::::: user index 설정 :::::::::::::::::::::::::::: //
	@GetMapping("/user/index")	
	public String userIndex() {
		return "user/template/index";
	}
	
}

package com.epl.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MemberTeamService;
import com.epl.vo.Team;

@RestController
public class MemberTeamRestController {
		@Autowired private MemberTeamService memberTeamService;
		
		@PostMapping("/getMemberTeamList")
		public List<Team> getMemberTeamList(){
			List<Team> list = memberTeamService.selectMemberTeam();
			return list;
		}
		
		@PostMapping("/getMemberTeamOne")
		public List<Team> getMemberTeamOne(HttpSession session){
			System.out.println("::::::::::teamOne C::::::::::::::::");
			String teamName = (String) session.getAttribute("teamName");
			System.out.println("teamName: "+teamName);
			List<Team> list = memberTeamService.selectMemberOne(teamName);
			System.out.println("RestController getMemberTeamOne param list"+list);
			return list;
		}
		
}
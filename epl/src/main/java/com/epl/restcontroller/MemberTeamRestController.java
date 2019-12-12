package com.epl.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MemberTeamService;
import com.epl.vo.Player;
import com.epl.vo.Team;

@RestController
public class MemberTeamRestController {
		@Autowired private MemberTeamService memberTeamService;
		// 팀 리스트
		@PostMapping("/getMemberTeamList")
		public List<Team> getMemberTeamList(){
			List<Team> list = memberTeamService.selectMemberTeam();
			return list;
		}
		//팀 상세정보
		@PostMapping("/getMemberTeamOne")
		public List<Team> getMemberTeamOne(HttpSession session){
			System.out.println("::::::::::teamOne C::::::::::::::::");
			String teamName = (String) session.getAttribute("teamName");
			System.out.println("teamName: "+teamName);
			List<Team> list = memberTeamService.selectMemberOne(teamName);
			System.out.println("RestController getMemberTeamOne param list"+list);
			return list;
		}
		//팀 상세정보에서 해당팀의 선수보기
		@PostMapping("/getMemberPlayersList")
		public List<Player> getMemberPlayerList(HttpSession session){
			String players = (String)session.getAttribute("teamName");
			System.out.println("RestController getMemberPlayerList param list : "+players);
			List<Player> list = memberTeamService.selectMemberPlayerList(players);
			System.out.println("RestController getMemberPlayerList param list : "+list);
			return list;
		}
		
}
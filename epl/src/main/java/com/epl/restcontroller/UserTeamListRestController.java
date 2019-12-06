package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.UserTeamService;
import com.epl.vo.Team;

@RestController
public class UserTeamListRestController {
		@Autowired private UserTeamService userTeamService;
		
		@PostMapping("/getUserTeamList")
		public List<Team> getUserTeamList(){
			List<Team> list = userTeamService.selectUserTeam();
			return list;
		}

}
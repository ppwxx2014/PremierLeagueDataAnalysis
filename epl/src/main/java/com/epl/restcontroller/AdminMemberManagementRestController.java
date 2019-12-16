package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.AdminMemberManagementService;
import com.epl.vo.MemberInfo;

@RestController
public class AdminMemberManagementRestController {
	@Autowired
	private AdminMemberManagementService adminMemberManagementService;
	
	@PostMapping("/getMemberList")
	public List<MemberInfo> getMemberList(){
		List<MemberInfo> list = adminMemberManagementService.getAdminMemberList();
		System.out.println("getBoardList"+list);
		return list;
	}
}

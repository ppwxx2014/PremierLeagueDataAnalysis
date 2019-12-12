package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.AdminIndexService;
import com.epl.vo.Admin;

@RestController
public class AdminIndexRestController {
	@Autowired
	private AdminIndexService adminIndexService;
	
	@PostMapping("/getAdminList")
	public List<Admin> getAdminList() {
		List<Admin> list = adminIndexService.getAdminList();
		System.out.println("list:" + list);
		return list;
	}
}

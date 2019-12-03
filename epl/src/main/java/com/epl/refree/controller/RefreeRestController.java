package com.epl.refree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.refree.service.RefreeService;
import com.epl.vo.Refree;

@RestController
public class RefreeRestController {
	@Autowired private RefreeService refreeService;
	
	@PostMapping("/addRefree")
	public int addRefree(Refree refree) {
		System.out.println("addRefree 입력실행");
		System.out.println("param refree :"+ refree);
		
		int refree2 = refreeService.addRefree(refree);
		System.out.print(refree2 +"행 실행 완료");
		
		return refree2;
	}
}

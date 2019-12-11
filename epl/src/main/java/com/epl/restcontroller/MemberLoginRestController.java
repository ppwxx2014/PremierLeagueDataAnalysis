package com.epl.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.MemberService;
import com.epl.vo.Member;

@RestController
public class MemberLoginRestController {
	@Autowired private MemberService memberService;
	
	@PostMapping("/getSessionInfo")
	public String getSessionInfo(HttpSession session) {
		String memberId = (String) session.getAttribute("memberId");
		System.out.println("sessionInfo : " + memberId);
		return memberId;
	}
	
	@PostMapping("/naverLoginData")
	public int naverLoginData(HttpSession session,
								@RequestParam("memberEmail") String memberEmail,
								@RequestParam("memberNickName") String memberNickName,
								@RequestParam("memberAge") String memberAge,
								@RequestParam("memberGender") String memberGender) {
		
		System.out.println(memberEmail);
		System.out.println(memberNickName);
		System.out.println(memberAge);
		System.out.println(memberGender);
		
		
		// 세션에 네이버 email저장
		Member member = new Member();
		member.setMemberId(memberEmail);
		member.setMemberNickName(memberNickName);
		member.setMemberAge(memberAge);
		member.setMemberGender(memberGender);
		
		session.setAttribute("memberId", memberEmail);
		Member memberConfirm = memberService.selectMemberOne(memberEmail);
		
		System.out.println(memberConfirm);
		int row = 0;
		if(memberConfirm.getMemberId() == null) {
			row = memberService.addMember(member);
		}else {
			if(memberConfirm.getMemberNickName() != memberNickName || memberConfirm.getMemberAge() != memberAge) {
				memberService.modifyMember(member);
			}
		}
		System.out.println("row : " + row);
		return row;
	}
}







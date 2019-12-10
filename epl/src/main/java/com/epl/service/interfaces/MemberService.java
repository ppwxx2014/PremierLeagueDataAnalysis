package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.Member;

public interface MemberService {
	List<Member> getMemberList(Member member);
	
	int addMember(Member member);
	
	String selectMemberOne(String memberEmail);
}

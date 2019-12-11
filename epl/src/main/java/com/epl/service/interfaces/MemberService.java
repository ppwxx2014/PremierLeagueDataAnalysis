package com.epl.service.interfaces;

import java.util.List;

import com.epl.vo.Member;

public interface MemberService {
	List<Member> getMemberList(Member member);
	
	int addMember(Member member);
	
	Member selectMemberOne(String memberEmail);
	
	int modifyMember(Member member);
}

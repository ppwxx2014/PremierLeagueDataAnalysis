package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.MemberMapper;
import com.epl.service.interfaces.MemberService;
import com.epl.vo.Member;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	@Autowired private MemberMapper memberMapper;
	
	@Override
	public int addMember(Member member) {
		int row = memberMapper.insertMember(member);
		System.out.println("MemberService:::::::" + row);
		
		return row;
	}
	
	@Override
	public List<Member> getMemberList(Member member) {
		List<Member> list = memberMapper.selectMemberList(member);
		
		return list;
	}
	
	@Override
	public Member selectMemberOne(String memberEmail) {
		Member memberConfirm = memberMapper.selectMemberOne(memberEmail);
		System.out.println("MemberService:::::::" + memberConfirm);
		return memberConfirm;
	}
	
	@Override
	public int modifyMember(Member member) {
		int row = memberMapper.updateMember(member);
		System.out.println("MemberService:::::::" + row);
		
		return row;
	}
}





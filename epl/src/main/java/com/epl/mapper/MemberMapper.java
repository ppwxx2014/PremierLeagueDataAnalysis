package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Member;
import com.epl.vo.Notice;

@Mapper
public interface MemberMapper {
	
	// 전체 맴버리스트
	List<Member> selectMemberList(Member member);
	
	// 유저 정보 입력
	int insertMember(Member member);
	
	// 유저 정보 상세보기
	Member selectMemberOne(String memberEmail);
	
	// 유저 정보 업데이트
	int updateMember(Member member);
	
}

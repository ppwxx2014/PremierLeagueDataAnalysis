package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.MemberInfo;

@Mapper
public interface AdminMemberManagementMapper {
	List<MemberInfo> selectAdminMemberList();
}

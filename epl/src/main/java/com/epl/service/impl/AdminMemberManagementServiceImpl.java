package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.AdminMemberManagementMapper;
import com.epl.service.interfaces.AdminMemberManagementService;
import com.epl.vo.MemberInfo;

@Service
@Transactional
public class AdminMemberManagementServiceImpl implements AdminMemberManagementService{
	@Autowired private AdminMemberManagementMapper adminMemberManagementMapper;
	
	@Override
	public List<MemberInfo> getAdminMemberList() {
		List<MemberInfo> list = adminMemberManagementMapper.selectAdminMemberList();
		System.out.println("AdminMemberManagementServiceImpl:::getAdminMemberList:::" + list);
		return list;
	}
}





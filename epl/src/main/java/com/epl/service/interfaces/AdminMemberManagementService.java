package com.epl.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.vo.MemberInfo;

@Service
@Transactional
public interface AdminMemberManagementService {
	
	public List<MemberInfo> getAdminMemberList();
}





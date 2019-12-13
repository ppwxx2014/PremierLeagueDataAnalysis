package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.AdminIndexMapper;
import com.epl.service.interfaces.AdminIndexService;
import com.epl.vo.Admin;

@Service
@Transactional
public class AdminIndexServiceImpl implements AdminIndexService{
	@Autowired private AdminIndexMapper adminIndexMapper;
	
	@Override
	public List<Admin> getAdminList() {
		List<Admin> list = adminIndexMapper.selectAdminList();
		System.out.println("AdminIndexServiceImpl:::getAdminList:::" + list);
		return list;
	}
}





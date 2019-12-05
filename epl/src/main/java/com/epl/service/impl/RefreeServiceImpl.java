package com.epl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.RefreeMapper;
import com.epl.service.interfaces.RefreeService;
import com.epl.vo.Refree;

@Service
@Transactional
public class RefreeServiceImpl implements RefreeService {
	@Autowired
	private RefreeMapper refreeMapper;

	// 심판추가
	@Override
	public int addRefree(Refree refree) {
		System.out.println("addRefree Service 요청");
		int row = refreeMapper.insertRefree(refree);
		return row;
	}

}

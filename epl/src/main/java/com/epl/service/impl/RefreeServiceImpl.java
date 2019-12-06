package com.epl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.RefreeMapper;
import com.epl.service.interfaces.RefreeService;
import com.epl.vo.Page;
import com.epl.vo.Player;
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

	@Override
	public int getRefreeCount(Page page) {
		System.out.println("getRefreeCount Service 요청");
		System.out.println("getRefreeCount param Page :"+page);
		
		int totalRowCount = refreeMapper.selectRefreeCount(page);
		
		return totalRowCount;
	}

	@Override
	public List<Refree> getRefreeList() {
		System.out.println("getRefreeList Service 요청");
		
		List<Refree> list = refreeMapper.selectRefreeList();
		
		return list;
	}

	@Override
	public List<Refree> getRefreeListByPage(int currentPage, int rowPerPage, String searchWord) {
		System.out.println("getRefreeListByPage Service 요청");
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage - 1) * rowPerPage);
		page.setSearchWord(searchWord);
		
		List<Refree> list = refreeMapper.selectRefreeListByPage(page);
		
		return list;
	}

}

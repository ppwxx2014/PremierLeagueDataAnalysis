package com.epl.service.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.epl.vo.Page;
import com.epl.vo.Refree;

public interface RefreeService {
	public int addRefree(Refree refree);
	
	public int getRefreeCount(Page page);
	
	public List<Refree> getRefreeList();
	
	public List<Refree> getRefreeListByPage(int currentPage, int rowPerPage, String searchWord);
}

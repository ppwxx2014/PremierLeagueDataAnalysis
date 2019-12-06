package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Page;
import com.epl.vo.Player;
import com.epl.vo.Refree;

@Mapper
public interface RefreeMapper {
	public int insertRefree(Refree refree);
	
	public int selectRefreeCount(Page page);
	
	public List<Refree> selectRefreeList();
	 
	public List<Refree> selectRefreeListByPage(Page page);
}

package com.epl.playercontract.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Page;
import com.epl.vo.PlayerContract;

@Mapper
public interface PlayerContractMapper {
	// 페이지 별 선수계약 리스트 출력
	public ArrayList<PlayerContract> selectPlayerContractListByPage(Page page);
	
	// 선수 계약 리스트 전체출력
	public List<PlayerContract> selectPlayerContractList();
	
	// 선수계약 수 출력
	public int selectPlayerContractCount(Page page);
	
	// 선수 계약 입력
	public int insertPlayerContract(PlayerContract playerContract);
}

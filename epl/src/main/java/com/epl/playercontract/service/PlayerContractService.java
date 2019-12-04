package com.epl.playercontract.service;

import java.util.List;
import java.util.Map;

import com.epl.vo.PlayerContract;

public interface PlayerContractService {
	// 선수 계약 입력
	public int addPlayerContract(PlayerContract playerContract);
	
	// 선수 계약 리스트 출력
	public List<PlayerContract> getPlayerList();
	
	// 선수 계약 리스트 페이지 출력
	public Map<String, Object> getPlayerListByPage(int currentPage, int rowPerPage, String searchWord);

}

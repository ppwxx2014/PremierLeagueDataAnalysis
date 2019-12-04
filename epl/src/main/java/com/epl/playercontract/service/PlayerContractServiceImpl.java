package com.epl.playercontract.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.playercontract.mapper.PlayerContractMapper;
import com.epl.vo.Page;
import com.epl.vo.PlayerContract;

@Service
@Transactional
public class PlayerContractServiceImpl implements PlayerContractService{
	@Autowired private PlayerContractMapper playerContractMapper;
	
	// 선수 계약 추가하기
	@Override
	public int addPlayerContract(PlayerContract playerContract) {
		System.out.println("addPlayerContract service 요청");
		int row = playerContractMapper.insertPlayerContract(playerContract);
		System.out.println("addPlayerContract service" +row+ "행 입력성공");
		return row;
	}
	
	// 선수 계약 리스트  가져오기
	@Override
	public List<PlayerContract> getPlayerList() {
		System.out.println("getPlayerList service 요청");
		
		List<PlayerContract> list = playerContractMapper.selectPlayerContractList();
		
		System.out.println("getPlayerList service list param : "+ list);
		
		
		return list;
	}
	// 펴이지별 선수 계약 리스트 가져오기
	@Override
	public Map<String, Object> getPlayerListByPage(int currentPage, int rowPerPage, String searchWord) {
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow( (currentPage - 1) * rowPerPage);
	    page.setSearchWord(searchWord);
	    
	    List<PlayerContract> list = playerContractMapper.selectPlayerContractListByPage(page);
	    int totalRowCount = playerContractMapper.selectPlayerContractCount(page);
	    int lastPage = totalRowCount/ rowPerPage;
	    
	    if(totalRowCount / rowPerPage != 0) {
	         lastPage += 1;
	    };
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list", list);
        map.put("currentPage", currentPage);
        map.put("totalRowCount", totalRowCount);
        map.put("lastPage", lastPage);
        map.put("searchWord", searchWord);
	    return map;
	}
}

package com.epl.position.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.position.mapper.PositionMapper;
import com.epl.vo.Position;

@Service
@Transactional
public class PositionServiceImpl implements PositionService{
	@Autowired private PositionMapper positionMapper;
	
	@Override
	public int selectPositionNo(Position position) {
		System.out.println("selectPositionNo service param position :"+position);
		return positionMapper.selectPositionNo(position);
	}
}

package com.epl.playerPosition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.playerPosition.mapper.PlayerPositionMapper;
import com.epl.vo.PlayerPosition;

@Service
@Transactional
public class PlayerPositionServiceImpl implements PlayerPositionService{
	@Autowired private PlayerPositionMapper playerPositionMapper;
	@Override
	public int addPlayerPosition(PlayerPosition playerPosition) {
		System.out.println("addPlayerPosition service 요청");
		int row = playerPositionMapper.insertPlayerPosition(playerPosition);
		System.out.println(row + "행 입력  실행 완료");
		return row;
	}
}

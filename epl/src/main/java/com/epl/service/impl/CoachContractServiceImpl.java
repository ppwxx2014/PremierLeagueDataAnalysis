package com.epl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.CoachContractMapper;
import com.epl.service.interfaces.CoachContractService;
import com.epl.vo.CoachContract;

@Service
@Transactional
public class CoachContractServiceImpl implements CoachContractService{
	@Autowired
	CoachContractMapper coachContractMapper;
	
	@Override
	public int addCoachContract(CoachContract coachContract) {

		return coachContractMapper.insertCoachContract(coachContract);
	}
}

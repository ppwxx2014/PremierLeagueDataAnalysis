package com.epl.coachcontract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.coachcontract.mapper.CoachContractMapper;
import com.epl.vo.CoachContract;


@Service
@Transactional
public class CoachContractServiceImpl {
	@Autowired CoachContractMapper coachContractMapper;
public int addCoachContract(CoachContract coachContract) {
		
		return coachContractMapper.insertCoachContract(coachContract);
	}
}

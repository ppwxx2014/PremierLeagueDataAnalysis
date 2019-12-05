package com.epl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.CountryMapper;
import com.epl.service.interfaces.CountryService;
import com.epl.vo.Country;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryMapper countrymapper;

	@Override
	public List<Country> getCountry() {
		List<Country> list = new ArrayList<>();
		list = countrymapper.selectCountry();
		System.out.println("selectCountryList Service result list : " + list);
		return list;
	}
}

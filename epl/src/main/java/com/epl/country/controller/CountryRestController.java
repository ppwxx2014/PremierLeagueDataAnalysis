package com.epl.country.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.country.service.CountryService;
import com.epl.vo.Country;

@RestController
public class CountryRestController {
	@Autowired CountryService countryService;
	
	@PostMapping("/getCountryList")
	public List<Country> getCountryList(){
		System.out.println("list country Controller 폼 요청");
		List<Country> list = countryService.getCountry();
		System.out.println("list : "+list);
		return list;
	}
	
}

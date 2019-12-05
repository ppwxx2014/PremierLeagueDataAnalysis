package com.epl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.epl.vo.Country;

@Mapper
public interface CountryMapper {
	public List<Country> selectCountry();
}
package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.Admin;

@Mapper
public interface AdminIndexMapper {
	List<Admin> selectAdminList();
}

package com.epl.manager.service;

import com.epl.vo.Admin;
import com.epl.vo.LoginForm;

public interface AdminService {
	Admin getAdminOne(LoginForm loginForm);
	int addAdmin(Admin admin);
	int modifyAdmin(Admin admin);
	void modifyAdminPw(String adminEmail);
}


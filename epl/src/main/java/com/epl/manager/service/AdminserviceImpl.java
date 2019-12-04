package com.epl.manager.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.manager.mapper.AdminMapper;
import com.epl.vo.Admin;
import com.epl.vo.LoginForm;
import com.epl.vo.MailForm;

@Service
@Transactional
public class AdminserviceImpl implements AdminService{
	@Autowired private JavaMailSender javaMailSender;
	@Autowired private AdminMapper adminMapper;
	
	//회원가입
	@Override
	public int addAdmin(Admin admin) {
		int row = adminMapper.insertAdmin(admin);
		System.out.println(row);
		return row;
	}
	
	//로그인 세션 가져오기
	@Override
	public Admin getAdminOne(LoginForm loginForm) {
		
		return adminMapper.selectAdminOne(loginForm);
	}
	
	
	// 수정
	@Override
	public int modifyAdmin(Admin admin) {
		System.out.println("modifyAdmin service param admin :" + admin);
		int row = adminMapper.updateAdmin(admin);
		System.out.println("adminModify:::::::::::::::::" + row);
		return row;
	}
	
	// 임시비밀번호 발송
	@Override
	public void modifyAdminPw(String adminEmail) {
		
		
		MailForm mailform = new MailForm();
		
		String text = UUID.randomUUID().toString().substring(0,6); // 임시비밀번호
		
		Admin admin = new Admin();
		admin.setAdminEmail(adminEmail);
		admin.setAdminPw(text);
		
		
		System.out.println(text);
		
		System.out.println("::::::::::::::::::" + adminEmail);
		mailform.setTo(adminEmail);
		mailform.setFrom("maintainhun1@gmail.com"); // 보내는 사람 이메일
		mailform.setSubject("임시 비밀번호입니다!");
		mailform.setText("임시비밀번호: "+text);
		
		// 기존 비밀번호를 임시비밀번호로 변경
		int row = adminMapper.updateAdminPw(admin);
		System.out.println("changeAdminPw::::::::::::::::::" + row);
		
		// 메세지 발송
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(mailform.getTo());
		simpleMailMessage.setFrom(mailform.getFrom());
		simpleMailMessage.setSubject(mailform.getSubject());
		simpleMailMessage.setText(mailform.getText());
		
		javaMailSender.send(simpleMailMessage);
	}
	
}

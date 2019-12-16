package com.epl.vo;

import lombok.Data;

@Data
public class MemberInfo {
	private String memberEmail;
	private String memberNickName;
	private String memberAge;
	private String memberGender;
	private int boardCount;
	private int commentCount;
}

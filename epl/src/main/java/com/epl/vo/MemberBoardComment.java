package com.epl.vo;

import lombok.Data;

@Data
public class MemberBoardComment {
	private int commentNo;
	private int boardNo;
	private String commentUser;
	private String memberNickName;
	private String commentContent;
	private String commentDate;
}

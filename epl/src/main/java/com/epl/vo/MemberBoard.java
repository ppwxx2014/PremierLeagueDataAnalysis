package com.epl.vo;

import lombok.Data;

@Data
public class MemberBoard {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardUser;
	private String boardDate;
	private MemberBoardfile memberBoardfile;
}

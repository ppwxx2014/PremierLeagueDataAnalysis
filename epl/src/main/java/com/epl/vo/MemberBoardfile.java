package com.epl.vo;

import lombok.Data;

@Data
public class MemberBoardfile {
	private int boardfileNo;
	private int boardNo;
	private String fileName;
	private String extension;
	private String contentType;
	private String originName;
	private long size;
}
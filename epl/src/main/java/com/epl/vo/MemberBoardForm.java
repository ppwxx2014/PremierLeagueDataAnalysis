package com.epl.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberBoardForm {
	private int boardNo;
	private String boardCategory;
	private String boardTitle;
	private String boardContent;
	private String boardUser;
	private String boardDate;
	private List<MultipartFile> boardfile; // 여러개 파일 업로드시 배열[] 또는 List<MultipartFile>...
}
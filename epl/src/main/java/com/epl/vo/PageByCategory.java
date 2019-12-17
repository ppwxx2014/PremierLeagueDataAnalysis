package com.epl.vo;

import lombok.Data;

@Data
public class PageByCategory {
	private int beginRow;
	private int rowPerPage;
	private String searchWord;
	private String category;
}

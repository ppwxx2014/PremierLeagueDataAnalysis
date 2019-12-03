package com.epl.vo;

import lombok.Data;

@Data
public class Image {
	private int imageNo;
	private String imageName;
	private String extension;
	private String contentType;
	private int size;
}

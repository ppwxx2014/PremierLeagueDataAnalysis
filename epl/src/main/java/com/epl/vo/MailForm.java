package com.epl.vo;

import lombok.Data;

@Data
public class MailForm {
	private String to;
    private String from;
    private String subject;
    private String text;
}

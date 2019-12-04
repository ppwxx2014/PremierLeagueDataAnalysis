package com.epl.vo;

import lombok.Data;

@Data
public class CoachContract {
	private int coachNo;
	private String teamName;
	private int salary;
	private String contractStart;
	private String contractEnd;
}

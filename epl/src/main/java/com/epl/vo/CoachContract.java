package com.epl.vo;

import lombok.Data;

@Data
public class CoachContract {
	private int coachNo;
	private int teamNo;
	private int salary;
	private String contractStart;
	private String contractEnd;
}

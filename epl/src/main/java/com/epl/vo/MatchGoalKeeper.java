package com.epl.vo;

import lombok.Data;

@Data
public class MatchGoalKeeper {
	private int matchNo;
	private int playerNo;
	private int save;
	private int saveOnPk;
	private int saveOnFk;
	private int yellowCard;
	private int redCard;
	private String startTime;
	private String endTime;
}

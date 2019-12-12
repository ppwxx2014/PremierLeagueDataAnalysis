package com.epl.vo;

import lombok.Data;

@Data
public class MatchOwnGoals {
	private int matchNo;
	private int playerNo;
	private String time;
	private int ownGoal;
}

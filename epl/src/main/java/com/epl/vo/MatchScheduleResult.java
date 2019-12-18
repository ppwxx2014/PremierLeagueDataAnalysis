package com.epl.vo;

import lombok.Data;

@Data
public class MatchScheduleResult {
	private int matchNo;
	private String hometeamName;
	private String awayteamName;
	private String active;
	private String matchDate;
	private String matchTime;
	private String winnerteamName;
	private int hometeamGoals;
	private int awayteamGoals;
}

package com.epl.vo;

import lombok.Data;

@Data
public class MatchSchedule {
	private int matchNo;
	private String hometeamName;
	private String awayteamName;
	private String matchDate;
	private String matchTime;
	private String stadiumName;
	private String active;
	private String refreeName;
}

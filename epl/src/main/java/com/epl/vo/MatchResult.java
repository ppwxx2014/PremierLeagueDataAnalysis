package com.epl.vo;

import lombok.Data;

@Data
public class MatchResult {
	private int matchNo;
	private String hometeamName;
	private String awayteamName;
	private String winnerteamName;
	private int hometeamGoals;
	private int awayteamGoals;
}

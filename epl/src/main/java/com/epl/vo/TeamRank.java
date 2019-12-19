package com.epl.vo;

import lombok.Data;

@Data
public class TeamRank {
	private String teamName;
	private int matchCount;
	private int goalCount;
	private int points;
}

package com.epl.vo;

import lombok.Data;

@Data
public class MatchPlayer {
	private int matchNo;
	private int playerNo;
	private int shooting;
	private int shootOnTarget;
	private int pass;
	private int assist;
	private int foul;
	private int tackle;
	private int	offside;
	private int goalOnPk;
	private int goalOnFk;
	private int yellowCard;
	private int	redCard;
	private String startTime;
	private String endTime; 
}

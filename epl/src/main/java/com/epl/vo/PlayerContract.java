package com.epl.vo;

import lombok.Data;

@Data
public class PlayerContract {
	private String teamName;
	private int playerNo;
	private String contractStart;
	private String contractEnd;
	private int salary;
	private int transferFee;
	private int uniformBackNumber;
	private String playerName;
}

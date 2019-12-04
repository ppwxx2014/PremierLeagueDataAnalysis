package com.epl.vo;

import lombok.Data;

@Data
public class PlayerContract {
	private String teamName;
	private int playerNo;
	private String contractStart;
	private String contractEnd;
	private int salary;
	private int trasferFee;
	private int uniformBackNo;
	private String playerName;
}

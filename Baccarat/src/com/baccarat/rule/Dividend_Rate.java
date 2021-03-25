package com.baccarat.rule;

public interface Dividend_Rate {
	
	double playerWin = 2.0;
	double bankerWin = 1.95;
	double tie = 8.0;
	double playerPair = 11.0;
	double bankerPair = 11.0;
	
	boolean winOrLose();
	boolean checkPair();
}

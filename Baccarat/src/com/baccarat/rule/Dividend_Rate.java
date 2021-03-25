package com.baccarat.rule;

import com.baccarat.card.CardOne;
import com.baccarat.card.CardValue;

public interface Dividend_Rate {
	
	double playerWin = 2.0;
	double bankerWin = 1.95;
	double tie = 8.0;
	double playerPair = 11.0;
	double bankerPair = 11.0;
	
	int winOrLose(int playerSC, int bankerSC);
	int cardScoreSum(CardOne[] cards);
	boolean checkPair(CardOne[] cards);
}

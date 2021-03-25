package com.baccarat.rule;

public class BaccaratGame_Rule implements Dividend_Rate {

	public int playerSC = 0;
	public int bankerSC = 0;
	
	@Override
	public boolean winOrLose() {
		boolean isc = false;
		int cardSC = 0;
		for (int i = 0; i < cardSC; i++) {
			
		
		if(playerSC > bankerSC) {
			System.out.println("Player Win!!");
		}else if(playerSC < bankerSC) {
			System.out.println("Banker Wiin!!");
		}else if(playerSC == bankerSC) {
			System.out.println("Tie!!");
		}
	}
		
		
		return isc;
	}

	@Override
	public boolean checkPair() {
		boolean isc = false;
		
		
		return isc;
	}
	
	
}

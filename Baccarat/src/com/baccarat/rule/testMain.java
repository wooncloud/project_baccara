package com.baccarat.rule;

import java.util.Arrays;

import com.baccarat.card.CardOne;

public class testMain {

	public static void main(String[] args) {

		System.out.println("[Player Card]");
		CardOne c1 = new CardOne();
		CardOne c2 = new CardOne();
		CardOne[] playerCards = { c1, c2 };
		System.out.println(Arrays.toString(playerCards));
		BaccaratGame_Rule rr = new BaccaratGame_Rule();
		System.out.println(rr.cardScoreSum(playerCards));

		System.out.println("[Bank Card]");
		CardOne c11 = new CardOne();
		CardOne c22 = new CardOne();
		CardOne[] bankerCards = { c11, c22 };
		System.out.println(Arrays.toString(bankerCards));
		System.out.println(rr.cardScoreSum(bankerCards));
		
		rr.checkPair(playerCards);
	}
}

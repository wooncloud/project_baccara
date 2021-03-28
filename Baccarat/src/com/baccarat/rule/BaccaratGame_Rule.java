package com.baccarat.rule;

import com.baccarat.card.CardOne;
import com.baccarat.card.CardValue;

public class BaccaratGame_Rule {

	public final static double PLAYER_WIN = 2.0;  
	public final static double BANKER_WIN = 1.95; 
	public final static double TIE = 8.0;        
	public final static double PAIR = 11.0;
	
	static int score;
	public int playerSC = 0;
	public int bankerSC = 0;

	/**
	 * 플레이어와 뱅커 점수를 보고 승패 결정 여부
	 * @param playerSC 플레이어 점수
	 * @param bankerSC 뱅커 점수
	 * @return 
	 */
	public int winOrLose(int playerSC, int bankerSC) {
		int result = 0;

			if (playerSC > bankerSC) {
				result = 1; // player win
			} else if (playerSC < bankerSC) {
				result = 2; // banker win
			} else if (playerSC == bankerSC) {
				result = 3; // tie
			}
		return result;
	}

	/**
	 * 
	 * @param cards
	 * @return
	 */
	public boolean checkPair(CardOne[] cards) {
		boolean isc = false;
		for (int i = 0; i < cards.length; i++) {
			int score1 = CardValue.Value(cards[i].getCard());
			int score2 = CardValue.Value(cards[i].getCard());
			
				if(score1 == score2) {
					isc = true;
				}
		}
		return isc;
		
	}
		

	/**
	 * 카드 2장의 합을 구해주는 메소드
	 */
	public static  int cardScoreSum(CardOne[] cards) {

		int sum = 0;
		for (int i = 0; i < cards.length; i++) {
			score = CardValue.Value(cards[i].getCard());
			sum += score;
		}
		return sum % 10;
	}

}

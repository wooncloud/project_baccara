package com.baccarat.rule;

import java.util.Arrays;

import com.baccarat.card.CardOne;

public class testMain {

	public static void main(String[] args) {

//		System.out.println("[Player Card]");
//		CardOne c1 = new CardOne();
//		CardOne c2 = new CardOne();
//		CardOne[] playerCards = { c1, c2 };
//		System.out.println(Arrays.toString(playerCards));
//		BaccaratGame_Rule rule = new BaccaratGame_Rule();
//		System.out.println(rule.cardScoreSum(playerCards));
//		
//		CardOne c11 = new CardOne();
//		CardOne c22 = new CardOne();
//		CardOne[] bankerCards = { c11, c22 };
//		judement jd = new judement();
//		int playerJM = rule.cardScoreSum(playerCards); // 플레이어 카드 스코어 판단해줌
//		int bankerJM = rule.cardScoreSum(bankerCards); // 뱅커 카드 스코어 판단해줌
//		judement.judgeP(playerJM,bankerJM);
//
//		System.out.println("[Bank Card]");
//		CardOne c111 = new CardOne();
//		CardOne c222 = new CardOne();
//		CardOne[] bankerCardss = { c11, c22 };
//		System.out.println(Arrays.toString(bankerCards));
//		System.out.println(rule.cardScoreSum(bankerCards));
//		
//		judement jd2 = new judement();
//		int playerJM2 = rule.cardScoreSum(playerCards); // 플레이어 카드 스코어 판단해줌
//		int bankerJM2 = rule.cardScoreSum(bankerCards); // 뱅커 카드 스코어 판단해줌
//		judement.judgeB(playerJM,bankerJM);
		
		BankerThird bt = new BankerThird();
		bt.bankAddCard();
	}
}

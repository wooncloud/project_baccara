package com.baccarat.card;

import java.util.ArrayList;

import java.util.List;

public class CardCase_JCF {

	private List<CardOne> cardcase;

	public CardCase_JCF() {
		cardcase = new ArrayList<CardOne>();
		randomCard();
	}

	/**
	 * 카드 케이스를 새로 카드를 채워서 만듬
	 */
	private void randomCard() {
		// 입력해야할 JCF의 최대 길이
		int inputIndex = CardOne.SHAPE.length * CardOne.NUMBER.length;
		int cnt = 0;
		while (true) {
			CardOne o = new CardOne();
			if (!cardcase.contains(o)) {
				cardcase.add(o);
				cnt++;
			}
			if (inputIndex == cnt) {
				break;
			}
		}
	}

	/**
	 * 카드케이스에서 랜덤으로 카드를 하나 빼온다.
	 * 
	 * @return 랜덤으로 뽑은 카드
	 */
	public CardOne randomOne() {
		int ran = (int) (Math.random() * (cardcase.size() - 1));
		CardOne card1 = cardcase.get(ran);

		cardcase.remove(cardcase.indexOf(card1));

		return card1;
	}

}

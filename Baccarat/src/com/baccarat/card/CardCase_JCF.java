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

	// 이건 없어도 될거 같아서 일단 보류
	public List<CardOne> getCardcase() {
		return cardcase;
	}

	public String randomOne(List<CardOne> cards) {

		double randomValue = Math.random();
		int ran = (int) (randomValue * cards.size()) - 1; // ran= cards배열의 인덱스번호

		CardOne card1 = cards.get(ran);
		cards.remove(cards.indexOf(card1));

		// System.out.println(card1);

		return card1.toString();
	}

}

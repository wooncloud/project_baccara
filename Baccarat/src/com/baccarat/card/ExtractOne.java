package com.baccarat.card;

import java.util.List;

public class ExtractOne {

	public CardOne randomOne(List<CardOne> cards) {

		double randomValue = Math.random();
		int ran = (int) (randomValue * cards.size()) - 1; // ran= cards배열의 인덱스번호
		CardOne card1 = cards.get(ran);
		System.out.println(card1);
		cards.remove(cards.indexOf(card1));
		return card1;
	}

}

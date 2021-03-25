package com.baccarat.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CardCase_Set {
	private Set<CardOne> cardSet;

	public CardCase_Set() {
		cardSet = new Set<CardOne>();
		randomCard();
	}
	
	private void randomCard() {
		// 입력해야할 JCF의 최대 길이
		int inputIndex = CardOne.SHAPE.length*CardOne.NUMBER.length;
		int cnt = 0;
		while (true) {
			CardOne o = new CardOne();
			if(!cardSet.contains(o)) {
				cardSet.add(o);
				cnt++;
			}
			if(inputIndex == cnt) {
				break;
			}
		}
	}
	
	public List<CardOne> getCardcase() {
		return cardSet;
	}


}

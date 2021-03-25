package com.baccarat.card;

import java.util.ArrayList;

import java.util.List;

public class CardCase_JCF {

	private List<CardOne> cardcase;

	public CardCase_JCF() {
		cardcase = new ArrayList<CardOne>();
		randomCard();
	}
	
	private void randomCard() {
		// 입력해야할 JCF의 최대 길이
		int inputIndex = CardOne.SHAPE.length*CardOne.NUMBER.length;
		int cnt = 0;
		while (true) {
			CardOne o = new CardOne();
			if(!cardcase.contains(o)) {
				cardcase.add(o);
				cnt++;
			}
			if(inputIndex == cnt) {
				break;
			}
		}
	}
	
	public List<CardOne> getCardcase() {
		return cardcase;
	}
		
}

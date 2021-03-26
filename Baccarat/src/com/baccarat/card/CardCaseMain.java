package com.baccarat.card;

import java.util.Arrays;
import java.util.List;

public class CardCaseMain {

	public static void main(String[] args) {
		// 1 생성확인
//		CardOne one = new CardOne();
//		System.out.println(one); // CardOne은 사용자가 만들었음 Object 표현을 package.Class@16진수hashcode

		// 2. toString 오버라이드 함
//		System.out.println(one);

		// 3. 카드케이스 객체를 생성해 본다
//		CardCase cc = new CardCase();
//		System.out.println(Arrays.toString(cc.getCardCase()));

		// 4JCF에 List를 사용한 카드 케이스
		CardCase_JCF cardList = new CardCase_JCF();
		List<CardOne> cards = cardList.getCardcase();
//		for(CardOne card : cards) {
//			System.out.println(card);
//		}

//		//랜덤으로하나뽑기 실험
//		double randomValue = Math.random();
//		int ran = (int)(randomValue * cards.size()) -1; //ran= cards배열의 인덱스번호
//		CardOne card =  cards.get(ran);

		System.out.println("셔플(덱생성) 완료!\n게임을 시작합니다\n" + cards);

		// RandomOne 확인
		ExtractOne eo = new ExtractOne();
		String pCard1 = eo.randomOne(cards);
		CardValue cv = new CardValue();
//		String pCard2 = eo.randomOne(cards); 
//		String pCard3 = eo.randomOne(cards); 

		// val추출 확인
		cv.Value(pCard1);
//		cv.Value(pCard2);
//		cv.Value(pCard3);

	}

}

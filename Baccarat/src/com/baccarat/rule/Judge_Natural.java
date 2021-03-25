package com.baccarat.rule;

import com.baccarat.card.CardOne;
import com.baccarat.card.ExtractOne;

public class Judge_Natural {
	String judgmentP = null;
	public String judgeP(int playerTwosum, int BankerTwosum ) {
		if (playerTwosum>=0&&playerTwosum<=5) {
			System.out.println("draw!!");
			judgmentP= "draw";
		}else if(playerTwosum==6 || playerTwosum ==7) {
			System.out.println("stand!!");
			judgmentP="stand";
		}else if(playerTwosum==8 || playerTwosum==9) {
			System.out.println("natural!!");
			judgmentP="natural" ;
		}
		return judgmentP;
	}
		
//	ExtractOne eo = new ExtractOne(); 
//	public void judgeB() {
//		Object card1;
//		CardOne plusCard = eo.randomOne(cards);
//		switch (judgmentP) {
//		case "draw":
//			plusCard = new CardOne();
//			break;
//			
//		case "stand":
//			break;
//			
//		case "natural":	
//			break;
//	}
//	
//	
//	
//		
//	}		
//	
}

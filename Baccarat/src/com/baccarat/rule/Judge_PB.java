package com.baccarat.rule;

public class Judge_PB {
	
	/**
	 * player두장 합에 따른 드로우 스탠드 네츄럴 판단
	 * player가 "draw"이면 세번째 카드를 뽑느다.
	 * int playerTwosum : 플레이어 첫 두장의 카드 포인트 밸류 값의 합
	 */
	String judgmentP = null;
	public String judgeP(int playerTwosum ) {
		if (playerTwosum>=0&&playerTwosum<=5) {
			System.out.println("draw!!");
			judgmentP= "draw";
		}else if(playerTwosum==6 || playerTwosum ==7) {
			System.out.println("player stand!!");
			judgmentP="stand";
		}else if(playerTwosum==8 || playerTwosum==9) {
			System.out.println("Player natural!!");
			judgmentP="natural" ;
		}
		return judgmentP;
	}//judgmentP = "draw" 면  player의 3번째 카드를 뽑는다. 딜러파트
		
	
 
	
	 
	/**
	 * 뱅커 두장 합에 따른  bankthird 판단.(플레이어 3번째 카드의 영향을 받는다.)
	 * judgmentB가 "natural"이거나 "stand"이면 딜러파트에서 카드를 뽑지 않는다.
	 * judgmentB가 "bankthird"이면 딜러파트에서 카드뽑아야한다. 
	 * int bankerTwosum : 뱅커 첫 두장의 포인트밸류 값 합
	 * int cardP3 : 플레이어 3번째 카드의 포인트밸류 값
	 */
	String judgmentB = null;
	public void judgeBankThird(int bankerTwosum, int cardP3) {
		switch (bankerTwosum) {//팩토리패턴을 쓰고싶지만 일단패스
		case 9 : 
			judgmentB = "natural";
			System.out.println("Banekr natural");
			break;
		case 8:
			judgmentB = "natural";
			System.out.println("Banker natural");
			break;
		
		case 7:
			judgmentB="stand";
			System.out.println("Banker Stand");//뱅커 카드안받음,플레이어는 받을 수도 있음(플레이어규칙을따름)	
			break;
			
		case 6: 
			if (cardP3==6||cardP3==7) {
				judgmentB = "bankthird";
				System.out.println("BankThird");
			}else {
				judgmentB="stand";
				System.out.println("Banker stand");
			}
			break;
		
		case 5:
			if (4<=cardP3&&cardP3<=7) {//4,5,6,7
				judgmentB = "bankthird";
				System.out.println("BankThird");
			}else {
				judgmentB="stand";
				System.out.println("Banker stand");
			}
			break;
		
		case 4:
			if (2<=cardP3&&cardP3<=7) {//2,3,4,5,6,7
				judgmentB = "bankthird";
				System.out.println("BankThird");
			}else {
				judgmentB="stand";
				System.out.println("Banker stand");
			}
			break;
		
		case 3:
			if (cardP3!=8) {//1,2,3,4,5,6,7,9,0
				judgmentB = "bankthird";
				System.out.println("BankThird");
			}else {
				judgmentB="stand";
				System.out.println("Banker stand");
			}
			break;
			
		default://bankerTwosum<=2일때
			judgmentB="stand";
			break;
		}	
	}	

	
		
}

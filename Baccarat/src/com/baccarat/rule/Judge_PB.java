package com.baccarat.rule;

public class Judge_PB {
	/**
	 * player두장 합에 따른 드로우 스탠드 네츄럴 판단<br>
	 * player가 "draw"이면 세번째 카드를 뽑느다.<br>
	 * int playerTwosum : 플레이어 첫 두장의 카드 포인트 밸류 값의 합
	 */
	public static String judgePlayer(int playerTwoSum) {
		String judgmentP = null;

		if (playerTwoSum >= 0 && playerTwoSum <= 5) {
//			System.err.println("draw!!");
			judgmentP = "draw";
		} else if (playerTwoSum == 6 || playerTwoSum == 7) {
//			System.err.println("player stand!!");
			judgmentP = "stand";
		} else if (playerTwoSum == 8 || playerTwoSum == 9) {
//			System.err.println("Player natural!!");
			judgmentP = "natural";
		}
		return judgmentP;
	}// judgmentP = "draw" 면 player의 3번째 카드를 뽑는다. 딜러파트

	public static boolean isBankerNatural(int bankerTwoSum) {
		boolean isc = false;

		switch (bankerTwoSum) {
		case 9:
		case 8:
			isc = true;
			break;
		default:
			isc = false;
			break;
		}
		
		return isc;
	}

	/**
	 * 뱅커 두장 합에 따른 bankthird 판단.(플레이어 3번째 카드의 영향을 받는다.)<br>
	 * judgmentB가 "natural"이거나 "stand"이면 딜러파트에서 카드를 뽑지 않는다.<br>
	 * judgmentB가 "bankthird"이면 딜러파트에서 카드뽑아야한다. <br>
	 * int bankerTwosum : 뱅커 첫 두장의 포인트밸류 값 합<br>
	 * int cardP3 : 플레이어 3번째 카드의 포인트밸류 값
	 */
	public static String judgeBankThird(int bankerTwoSum, int cardP3) {
		String judgmentB = null;

		switch (bankerTwoSum) {// 팩토리패턴을 쓰고싶지만 일단패스
		case 9:
			judgmentB = "natural";
//			System.err.println("Banekr natural");
			break;
		case 8:
			judgmentB = "natural";
//			System.err.println("Banker natural");
			break;

		case 7:
			judgmentB = "stand";
//			System.err.println("Banker Stand");// 뱅커 카드안받음,플레이어는 받을 수도 있음(플레이어규칙을따름)
			break;

		case 6:
			if (cardP3 == 6 || cardP3 == 7) {
				judgmentB = "draw";
//				System.err.println("draw");
			} else {
				judgmentB = "stand";
//				System.err.println("Banker stand");
			}
			break;

		case 5:
			if (4 <= cardP3 && cardP3 <= 7) {// 4,5,6,7
				judgmentB = "draw";
//				System.err.println("draw");
			} else {
				judgmentB = "stand";
//				System.err.println("Banker stand");
			}
			break;

		case 4:
			if (2 <= cardP3 && cardP3 <= 7) {// 2,3,4,5,6,7
				judgmentB = "draw";
//				System.err.println("draw");
			} else {
				judgmentB = "stand";
//				System.err.println("Banker stand");
			}
			break;

		case 3:
			if (cardP3 != 8) {// 1,2,3,4,5,6,7,9,0
				judgmentB = "draw";
//				System.err.println("draw");
			} else {
				judgmentB = "stand";
//				System.err.println("Banker stand");
			}
			break;

		default:// bankerTwosum <= 2 일때
			judgmentB = "draw";
			break;
		}

		return judgmentB;
	}

}

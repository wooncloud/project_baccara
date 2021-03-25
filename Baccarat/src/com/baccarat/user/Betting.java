package com.baccarat.user;

public class Betting {
	
	private int firstMoney;
	private int sum; // 배팅한 금액의 총 합
	private int betPlayer; // player에 배팅한 금액
	private int betBanker; // banker에 배팅한 금액
	private int betTie; // Tie에 배팅한 금액
	private int betPlayerPair; // player pair에 배팅한 금액
	private int betBankerPair; // banker pair에 배팅한 금액
	
	public void startBet() {
		
		System.out.println("초기 자산을 입력하세요 : ");
		firstMoney = InputVal.returnInt();
		
		System.out.println("어디에 배팅하시겠습니까?");
		System.out.println("1. Player");
		System.out.println("2. Banker");
		
		// 1, 2만 입력되도록 while
		int choice = InputVal.returnInt();
		switch (choice) {
		case 1:
			// 초기 자산을 넘으면 안됨.
			System.out.println("player에 배팅할 금액을 입력하세요 : ");
			betPlayer = InputVal.returnInt();
			break;
		case 2:
			System.out.println("banker에 배팅할 금액을 입력하세요 : ");
			betBanker = InputVal.returnInt();
			break;
		}
		
		
		sum = betPlayer + betBanker + betTie + betPlayerPair + betBankerPair;
		
	}


	public int getSum() {
		return sum;
	}


	public int getBetPlayer() {
		return betPlayer;
	}


	public int getBetBanker() {
		return betBanker;
	}


	public int getBetTie() {
		return betTie;
	}


	public int getBetPlayerPair() {
		return betPlayerPair;
	}


	public int getBetBankerPair() {
		return betBankerPair;
	}


	public int getFirstMoney() {
		return firstMoney;
	}
	
	
	
	
}

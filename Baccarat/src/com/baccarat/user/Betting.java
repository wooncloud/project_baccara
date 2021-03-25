package com.baccarat.user;

public class Betting {
	
	private int firstMoney;
	private int sum; // 배팅한 금액의 총 합
	private int betPlayer; // player에 배팅한 금액
	private int betBanker; // banker에 배팅한 금액
	private int betTie; // Tie에 배팅한 금액
	private int betPlayerPair; // player pair에 배팅한 금액
	private int betBankerPair; // banker pair에 배팅한 금액

	public Betting() {
		
	}
	
	public void startBet() {
		boolean isc = true;
		
		System.out.println("초기 자산을 입력하세요 : ");
		firstMoney = InputVal.returnInt();
		
		System.out.println("어디에 배팅하시겠습니까?");
		System.out.println("1. Player");
		System.out.println("2. Banker");
		int choice = InputVal.returnInt();
		switch (choice) {
		case 1:
			while (isc) {
				System.out.println("배팅할 금액을 입력하세요 : ");
				betPlayer = InputVal.returnInt();
				if (betPlayer > firstMoney) {
					System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
				}else {
					isc = false;
				}
			}
			isc = true;
			break;
		case 2:
			System.out.println("배팅할 금액을 입력하세요 : ");
			betBanker = InputVal.returnInt();
			break;
		default:
			break;
		}
		
		// sum : 배팅한 금액의 총 합
		sum = betPlayer+betBanker+betTie+betPlayerPair+betBankerPair;
		
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

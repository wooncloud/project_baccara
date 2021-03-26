package com.baccarat.user;

public class User {
	
	private int sum; // 배팅한 금액의 총 합
	private int betPlayer; // player에 배팅한 금액
	private int betBanker; // banker에 배팅한 금액
	private int betTie; // Tie에 배팅한 금액
	private int betPlayerPair; // player pair에 배팅한 금액
	private int betBankerPair; // banker pair에 배팅한 금액
	
	private static User user;
	
	private User() {
	}
	
	private User(int sum) {
		this.sum = sum;
	}
	
	public static User getInstance() {
		if(user==null) {
			user = new User();
		}
		return user;
	}
	
	public int firstMoney() {
		int money = 0;
		money = InputVal.returnInt();
		return money;
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
	
	
	
}

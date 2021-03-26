package com.baccarat.user;

/**
 * 배팅을 진행하고 나오는 결과를 갖고있는 객체
 * @author fhyun
 *
 */
public class User {
	
	private int sum; // 배팅한 금액의 총 합
	private int betPlayer; // player에 배팅한 금액
	private int betBanker; // banker에 배팅한 금액
	private int betTie; // Tie에 배팅한 금액
	private int betPlayerPair; // player pair에 배팅한 금액
	private int betBankerPair; // banker pair에 배팅한 금액
	private int balance; // 입력한 초기자산 - sum
	
	private static User user;
	
	private User() {
	}
	
	public void setBet(int sum, int p, int b, int t, int pp, int bp, int balance) {
		this.sum = sum;
		this.betPlayer = p;
		this.betBanker = b;
		this.betTie = t;
		this.betPlayerPair = pp;
		this.betBankerPair = bp;
		this.balance = balance;
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
	public int getBalance() {
		return balance;
	}
	
}

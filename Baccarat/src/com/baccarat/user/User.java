package com.baccarat.user;

import com.baccarat.util.InputVal;

/**
 * 배팅을 진행하고 나오는 결과를 갖고있는 객체
 * 
 * @author fhyun
 *
 */
public class User {

	// 유저 초기 자금 상수
	private final int INIT_USER_MONEY = 5000;

	private int sum; // 배팅한 금액의 총 합
	private int betPlayer; // player에 배팅한 금액
	private int betBanker; // banker에 배팅한 금액
	private int betTie; // Tie에 배팅한 금액
	private int betPlayerPair; // player pair에 배팅한 금액
	private int betBankerPair; // banker pair에 배팅한 금액
	private int balance; // 입력한 초기자산 - sum

	private static User user;

	private User() {
		// 유저가 생성될때 초기 자금을 가지고 시작하게 함.
		this.balance = INIT_USER_MONEY;
	}

	// 유저 싱글턴
	public static User getInstance() {
		if (user == null) {
			user = new User();
		}
		return user;
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

	// regacy : 이 함수는 더이상 사용되지 안습니다.
	// 이전 테스트용.
	public int firstMoney() {
		int money = 0;
		money = InputVal.returnInt();
		return money;
	}
	
	// Getter ------------->

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

	// <---------- Getter End
	
}

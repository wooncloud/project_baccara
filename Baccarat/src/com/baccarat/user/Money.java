package com.baccarat.user;

/**
 * 배팅 후 초기 자산에서 배팅한 총 금액을 빼고 남은 금액을 int 타입으로 반환함
 * @author fhyun
 *
 */
public class Money {

	private int money;
	
	public int balance() {
		Betting bet = new Betting();
		bet.startBet();
		money = (bet.getFirstMoney() - bet.getSum());		
		return money;
	}
	
}

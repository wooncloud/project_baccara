package com.baccarat.dealer;

public class Dealer {

	// 카드케이스 객체
	// 카드 룰

	public Dealer() {
		// 카드케이스 생성
		// 카드 룰 생성
	}

	/**
	 * 딜러가 게임의 흐름을 제어한다.
	 */
	public void gameFlow() {
		// 플레이어 객체를 받아와서 배팅

		// 카드 뽑기
		cardDraw();

		// 카드 룰에서 네츄럴인지 확인
		// 네츄럴이면 카드룰.승패확인
		// 아니면 카드룰.카드체크
	}

	/**
	 * 카드 케이스로부터 카드를 받는다.
	 */
	public void cardDraw(/* 카드 케이스 객체 받아옴 */) {
		// 카드케이스.겟카드
	}

	/**
	 * 배당 계산
	 */
	private void allocation() {
		// 배당
	}

	/**
	 * 유저의 돈을 보고 파산했는지 확인한다.
	 * @return 유저가 파산했으면 true 아니면 false
	 */
	public boolean userMoneyCheck() {
		boolean isc = false;
		
		return isc;
	}

}

package com.baccarat.main;

import com.baccarat.dealer.Dealer;

/**
 * Main에서 실행 할 게임의 전체 프레임입니다.
 * @author Woon
 *
 */
public class BaccaratGame {

	/**
	 * 하나의 큰 게임에 돌아갈 게임 판 수.
	 */
	private int gameCount = 5;

	/**
	 * Main에서 실행하는 실질적인 실행부입니다.
	 */
	public void play() {
		// 플레이어가 계속 게임을 할지 안할지 여부를 체크하는 boolean 변수
		boolean isContinue = false;

		do {
			// 유저 생성
			Dealer dealer = new Dealer();

			// 게임 5판은 무조건 한다.
			for (int i = 0; i < gameCount; i++) {
				dealer.gameFlow();

				// 파산 체크해서 파산이면 out
				if (dealer.userMoneyCheck()) {
					System.out.println("[ 파산하셨습니다. 게임을 종료합니다. ]");
					break;
				}
			}

			System.out.print("게임이 끝났습니다. 한번 더 하시겠습니까? : ");
			//TODO : isContinue = is Continue? 입력받음
			
		} while (isContinue);
	}

}

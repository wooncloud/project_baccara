package com.baccarat.main;

import com.baccarat.dealer.Dealer;
import com.baccarat.user.User;
import com.baccarat.util.InputVal;

/**
 * Main에서 실행 할 게임의 전체 프레임입니다.
 * 
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
		boolean isContinue = true;

		do {
			User user = User.getInstance(); // 유저 생성
			user.moneyReset();
			Dealer dealer = new Dealer(); // 딜러 생성

			// 게임 5판은 무조건 한다.
			for (int i = 0; i < gameCount; i++) {
				System.out.printf("<<< %d번째 게임 >>>\n", i + 1);

				dealer.gameFlow();

				// 파산 체크해서 파산이면 out
				if (dealer.userMoneyCheck(user)) {
					System.out.println("[ --- 당신은 파산하셨습니다. 게임을 종료합니다. --- ]");
					break;
				}
			}

			System.out.print("> 게임이 끝났습니다. 한번 더 하시겠습니까? (Y/N) : ");
			// isContinue = is Continue? 입력받음
			isContinue = true;
			if (InputVal.returnString().toUpperCase().trim().compareTo("N") == 0) {
				isContinue = false;
				System.out.println("[ Game Over ]");
			}
		} while (isContinue);
	}

}

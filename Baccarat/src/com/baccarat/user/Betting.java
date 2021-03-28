package com.baccarat.user;

import com.baccarat.util.InputVal;

public class Betting {

	public void startBet() {
		// 유저를 싱글턴으로 받아옴.
		User user = User.getInstance();

		// regacy : 테스트용으로 초기자산 받는건 더이상 사용하지 않음.
//		System.out.println("초기 자산을 입력하세요 : ");
//		int firstMoney = user.firstMoney();

		
		// 0. Init 유저의 정보를 가져옴.
		int balance = user.getBalance();
		int sum = user.getSum();

		int p = user.getBetPlayer();
		int b = user.getBetBanker();
		int t = user.getBetTie();
		int pp = user.getBetPlayerPair();
		int bp = user.getBetBankerPair();
		// 벨런스 빼고 다 어짜피 0 아닌가?
		
		// 현재 balance 출력
		System.out.printf("[ 돈 : %d ] \n", balance);
		
		// 1. Player or Banker 선택 배팅 로직
		int choice = 0;
		choice = ChoiceBet(choice);

		// 2. 선택한 배팅에 금액 입력
		switch (choice) {
		case 1:
			System.out.print("> Player에 배팅할 금액을 입력하세요 : ");
			p = betPlayer(balance);
			balance -= p;

			System.out.println("[Player에 배팅하셨습니다.]");
			break;

		case 2:
			System.out.print("> Banker에 배팅할 금액을 입력하세요 : ");
			b = betBanker(balance);
			balance -= b;

			System.out.println("[뱅커에 배팅하셨습니다.]");
			break;
		}

		// 3. 추가 배팅 로직
		System.out.println("\n[추가로 배팅할 금액을 입력해주세요.]");
		System.out.print("> 'Tie'에 배팅 할 금액을 입력해주세요 : ");
		t = betTie(balance);
		balance -= t;

		System.out.print("> 'Player Pair'에 배팅 할 금액을 입력해주세요 : ");
		pp = betPlayerPair(balance);
		balance -= pp;

		System.out.print("> 'Banker Pair'에 배팅 할 금액을 입력해주세요 : ");
		bp = betBankerPair(balance);
		balance -= bp;

		// 입력받은 값들을 User 객체에 전달
		sum = p + b + t + pp + bp;
		user.setBet(sum, p, b, t, pp, bp, balance);

		// test용 출력문
//		System.out.println("배팅완료");
//		System.out.printf("[테스트] 배팅한 금액의 합 : %d / 남은잔액 : %d", sum, balance);
	}

	/**
	 * 어디다 배팅할지 선택하는 메서드
	 * 
	 * @param choice
	 * @return
	 */
	private int ChoiceBet(int choice) {
		boolean isc = true;

		System.out.println("--------------------");
		System.out.println("[ 어디에 배팅하시겠습니까? ]");
		System.out.println("1. Player");
		System.out.println("2. Banker");
		System.out.println("--------------------");

		while (isc) {
			choice = InputVal.returnInt();
			if (!(choice == 1 || choice == 2)) {
				System.err.println("잘못된 입력값입니다. 다시 입력해주세요.");
				System.out.println("1. Player\n2. Banker");
			} else {
				isc = false;
			}
		}
		return choice;
	}

	/**
	 * Player에 배팅하는 금액을 int로 반환하는 메소드 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면 다시
	 * 입력받게 한다.
	 * 
	 * @param tmpbalance
	 * @return user.getBetPlayer
	 */
	private int betPlayer(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetPlayer();
		return bettingInputProcess(tmpbal, input);
	}

	/**
	 * Banker에 배팅하는 금액을 int로 반환하는 메소드 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면 다시
	 * 입력받게 한다.
	 * 
	 * @param tmpbalance
	 * @return user.getBetBanker
	 */
	private int betBanker(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetBanker();
		return bettingInputProcess(tmpbal, input);
	}

	/**
	 * Tie에 배팅하는 금액을 int로 반환하는 메소드 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면 다시
	 * 입력받게 한다.
	 * 
	 * @param tmpbalance
	 * @return user.getBetTie
	 */
	private int betTie(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetTie();
		return bettingInputProcess(tmpbal, input);
	}

	/**
	 * PlayerPair에 배팅하는 금액을 int로 반환하는 메소드 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면
	 * 다시 입력받게 한다.
	 * 
	 * @param tmpbalance
	 * @return user.getBetPlayerPair
	 */
	private int betPlayerPair(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetPlayerPair();
		return bettingInputProcess(tmpbal, input);
	}

	/**
	 * BankerPair에 배팅하는 금액을 int로 반환하는 메소드 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면
	 * 다시 입력받게 한다.
	 * 
	 * @param tmpbalance
	 * @return user.getBetBankerPair
	 */
	private int betBankerPair(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetBankerPair();
		return bettingInputProcess(tmpbal, input);
	}
	
	private int bettingInputProcess(int tmpbal, int input) {
		boolean isc = true;
		while (isc) {
			input = InputVal.returnInt();
			if (input > tmpbal) {
				overBetPrint();
			} else {
				isc = false;
			}
		}
		return input;
	}

	private void overBetPrint() {
		System.err.println("[가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.]");
	}

}

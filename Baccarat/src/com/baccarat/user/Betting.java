package com.baccarat.user;

public class Betting{
	
	public void startBet(User dto) {
		User user = User.getInstance();
		System.out.println("초기 자산을 입력하세요 : ");
		int firstMoney = user.firstMoney();
		int balance = firstMoney;
		int sum = user.getSum();
		int p = user.getBetPlayer();
		int b = user.getBetBanker();
		int t = user.getBetTie();
		int pp = user.getBetPlayerPair();
		int bp = user.getBetBankerPair();
		
		boolean isc = true;
		int choice = 0;
		
		System.out.println("어디에 배팅하시겠습니까?");
		System.out.println("1. Player");
		System.out.println("2. Banker");
		while (isc) {
			choice = InputVal.returnInt();
			if(! (choice == 1 || choice == 2)) {
				System.err.println("잘못된 입력값입니다. 다시 입력해주세요.");
				System.out.println("1. Player\n2. Banker");
			}else {
				isc = false;
			}
		}
		switch (choice) {
		case 1:
			System.out.println("Player에 배팅할 금액을 입력하세요 : ");
			p = betPlayer(balance);
			balance -= -p;
			
			System.out.println("Player에 배팅하셨습니다. 추가로 배팅할 금액을 입력해주세요.\n");
			
			System.out.println("Tie에 배팅 할 금액을 입력해주세요.");
			t = betTie(balance);
			balance -= t;
			
			System.out.println("PlayerPair에 배팅 할 금액을 입력해주세요.");
			pp = betPlayerPair(balance);
			balance -= pp;
			
			System.out.println("BankerPair에 배팅 할 금액을 입력해주세요.");
			bp = betBankerPair(balance);
			balance -= bp;
			
			break;
			
		case 2:
			System.out.println("Banker에 배팅할 금액을 입력하세요 : ");
			b = betBanker(balance);
			balance -= b;
			
			System.out.println("뱅커에 배팅하셨습니다. 추가로 배팅할 금액을 입력해주세요.\n");
			
			System.out.println("Tie에 배팅 할 금액을 입력해주세요.");
			t = betTie(balance);
			balance -= t;
			
			System.out.println("PlayerPair에 배팅 할 금액을 입력해주세요.");
			pp = betPlayerPair(balance);
			balance -= pp;
			
			System.out.println("BankerPair에 배팅 할 금액을 입력해주세요.");
			bp = betBankerPair(balance);
			balance -= bp;
			
			break;
		}
		// 입력받은 값들을 User 객체에 전달
		sum = p+b+t+pp+bp;
		user.setBet(sum, p, b, t, pp, bp, balance);
		
		// test용 출력문
		System.out.println("배팅완료");
		System.out.printf("배팅한 금액의 합 : %d / 남은잔액 : %d",sum,balance);
		
		
	}
	
	/**
	 * Player에 배팅하는 금액을 int로 반환하는 메소드
	 * 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면 다시 입력받게 한다.
	 * @param tmpbalance
	 * @return user.getBetPlayer
	 */
	private int betPlayer(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetPlayer();
		boolean isc = true;
		while (isc) {
			input = InputVal.returnInt();
			if (input > tmpbal) {
				System.err.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
			}else {
				isc = false;
			}
		}
		return input;
	}
	
	/**
	 * Banker에 배팅하는 금액을 int로 반환하는 메소드
	 * 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면 다시 입력받게 한다.
	 * @param tmpbalance
	 * @return user.getBetBanker
	 */
	private int betBanker(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetBanker();
		boolean isc = true;
		while (isc) {
			input = InputVal.returnInt();
			if (input > tmpbal) {
				System.err.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
			}else {
				isc = false;
			}
		}
		return input;
	}
	
	
	
	/**
	 * Tie에 배팅하는 금액을 int로 반환하는 메소드
	 * 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면 다시 입력받게 한다.
	 * @param tmpbalance
	 * @return user.getBetTie
	 */
	private int betTie(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetTie();
		boolean isc = true;
		while (isc) {
			input = InputVal.returnInt();
			if (input > tmpbal) {
				System.err.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
			}else {
				isc = false;
			}
		}
		return input;
	}
	
	/**
	 * PlayerPair에 배팅하는 금액을 int로 반환하는 메소드
	 * 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면 다시 입력받게 한다.
	 * @param tmpbalance
	 * @return user.getBetPlayerPair
	 */
	private int betPlayerPair(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetPlayerPair();
		boolean isc = true;
		while (isc) {
			input = InputVal.returnInt();
			if (input > tmpbal) {
				System.err.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
			}else {
				isc = false;
			}
		}
		return input;
	}
	
	/**
	 * BankerPair에 배팅하는 금액을 int로 반환하는 메소드
	 * 메소드 안에서 남은 잔액과 비교하여 배팅을 할 수 있으면 반환하고 초과한다면 다시 입력받게 한다.
	 * @param tmpbalance
	 * @return user.getBetBankerPair
	 */
	private int betBankerPair(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetBankerPair();
		boolean isc = true;
		while (isc) {
			input = InputVal.returnInt();
			if (input > tmpbal) {
				System.err.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
			}else {
				isc = false;
			}
		}
		return input;
	}
	
}

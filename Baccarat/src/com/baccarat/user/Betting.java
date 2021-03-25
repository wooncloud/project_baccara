package com.baccarat.user;

public class Betting{
	
//	private int firstMoney;
//	private int sum; // 배팅한 금액의 총 합
//	private int betPlayer; // player에 배팅한 금액
//	private int betBanker; // banker에 배팅한 금액
//	private int betTie; // Tie에 배팅한 금액
//	private int betPlayerPair; // player pair에 배팅한 금액
//	private int betBankerPair; // banker pair에 배팅한 금액

	
	
	public void startBet(User dto) {
		User user = User.getInstance();
		boolean isc = true;
		System.out.println("초기 자산을 입력하세요 : ");
		int firstMoney = user.firstMoney();
		int tmpBalance = firstMoney;
		
		System.out.println("어디에 배팅하시겠습니까?");
		System.out.println("1. Player");
		System.out.println("2. Banker");
		int choice = InputVal.returnInt();
		switch (choice) {
		case 1:
			while (isc) {
				System.out.println("Player에 배팅할 금액을 입력하세요 : ");
				int bp = user.getBetPlayer();
				bp = InputVal.returnInt();
				if (bp > firstMoney) {
					System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
				}else {
					isc = false;
				}
			}
			tmpBalance = firstMoney - user.getBetPlayer();
			isc = true;
			
			System.out.println("Player에 배팅하셨습니다.");
			while (isc) {
				System.out.println("Tie에 배팅 할 금액을 입력해주세요.");
				isc = betT(tmpBalance);
			}
			tmpBalance -= user.getBetTie();
			isc = true;
			
			while (isc) {
				System.out.println("PlayerPair에 배팅 할 금액을 입력해주세요.");
				isc = betPP(tmpBalance);
			}
			tmpBalance -= user.getBetPlayerPair();
			isc = true;
			
			while (isc) {
				System.out.println("BankerPair에 배팅 할 금액을 입력해주세요.");
				isc = betBP(tmpBalance);
			}
			tmpBalance -= user.getBetBankerPair();
			isc = true;
			
			break;
			
			
		case 2:
//			while (isc) {
//				System.out.println("Banker에 배팅할 금액을 입력하세요 : ");
//				betBanker = InputVal.returnInt();
//				if(betBanker > firstMoney) {
//					System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
//				}else {
//					isc = false;
//				}
//			}
//			tmpBalance = firstMoney - betBanker;
//			isc = true;
			
			System.out.println("뱅커에 배팅하셨습니다.");
			while (isc) {
				System.out.println("Tie에 배팅 할 금액을 입력해주세요.");
				isc = betT(tmpBalance);
			}
			tmpBalance -= user.getBetTie();
			isc = true;
			
			while (isc) {
				System.out.println("PlayerPair에 배팅 할 금액을 입력해주세요.");
				isc = betPP(tmpBalance);
			}
			tmpBalance -= user.getBetPlayerPair();
			isc = true;
			
			while (isc) {
				System.out.println("BankerPair에 배팅 할 금액을 입력해주세요.");
				isc = betBP(tmpBalance);
			}
			tmpBalance -= user.getBetBankerPair();
			isc = true;
			
			break;
			
		default:
			System.out.println("잘못된 입력입니다. 1 (Player) 또는 2 (Banker) 숫자를 입력하여 배팅을 진행해주세요.");
		}
		
		// sum : 배팅한 금액의 총 합
		int sum = user.getSum();
		sum = user.getBetPlayer()+user.getBetBanker()+user.getBetTie()+user.getBetPlayerPair()+user.getBetBankerPair();
		System.out.println("배팅한 금액의 총합은 "+sum);
	}
	
	
	
	/**
	 * Tie 배팅을 위해 입력받는 금액이 잔액보다 큰지 체크하는 메소드
	 * @param tmpbalance를 받는다
	 * @return 입력받는 금액이 더 클 경우 true를 반환, 배팅을 진행할 수 없다.
	 */
	private boolean betT(int tmpbal) {
		User user = User.getInstance();
		boolean isc = true;
		int input = user.getBetTie();
		input = InputVal.returnInt();
		if(input > tmpbal) {
			System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
		}else {
			isc = false;
		}
		return isc;
	}
	
	
	/**
	 * PlayerPair 배팅을 위해 입력받는 금액이 잔액보다 큰지 체크하는 메소드
	 * @param tmpbalance를 받는다
	 * @return 입력받는 금액이 더 클 경우 true를 반환, 배팅을 진행할 수 없다.
	 */
	private boolean betPP(int tmpbal) {
		User user = User.getInstance();
		boolean isc = true;
		int input = user.getBetPlayerPair();
		input = InputVal.returnInt();
		if(input > tmpbal) {
			System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
		}else {
			isc = false;
		}
		return isc;
	}
	
	/**
	 * BankerPair 배팅을 위해 입력받는 금액이 잔액보다 큰지 체크하는 메소드
	 * @param tmpbalance를 받는다
	 * @return 입력받는 금액이 더 클 경우 true를 반환, 배팅을 진행할 수 없다.
	 */
	private boolean betBP(int tmpbal) {
		User user = User.getInstance();
		boolean isc = true;
		int input = user.getBetBankerPair();
		input = InputVal.returnInt();
		if(input > tmpbal) {
			System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
		}else {
			isc = false;
		}
		return isc;
	}
	
}

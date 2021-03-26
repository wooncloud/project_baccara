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
		int sum = user.getSum();
		int p = user.getBetPlayer();
		int b = user.getBetBanker();
		int t = user.getBetTie();
		int pp = user.getBetPlayerPair();
		int bp = user.getBetBankerPair();
		
		System.out.println("어디에 배팅하시겠습니까?");
		System.out.println("1. Player");
		System.out.println("2. Banker");
		int choice = InputVal.returnInt();
		switch (choice) {
		case 1:
			while (isc) {
				System.out.println("Player에 배팅할 금액을 입력하세요 : ");
				p = InputVal.returnInt();
				if (p > firstMoney) {
					System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
				}else {
					isc = false;
				}
			}
			tmpBalance = firstMoney-p;
			isc = true;
			
			System.out.println("Player에 배팅하셨습니다. 추가로 배팅할 금액을 입력해주세요.\n");
			
			System.out.println("Tie에 배팅 할 금액을 입력해주세요.");
			t = betTie(tmpBalance);
			tmpBalance -= t;
			
			System.out.println("PlayerPair에 배팅 할 금액을 입력해주세요.");
			pp = betPlayerPair(tmpBalance);
			tmpBalance -= pp;
			
			System.out.println("BankerPair에 배팅 할 금액을 입력해주세요.");
			bp = betBankerPair(tmpBalance);
			tmpBalance -= bp;
			
			break;
			
			
		case 2:
			while (isc) {
				System.out.println("Banker에 배팅할 금액을 입력하세요 : ");
				b = InputVal.returnInt();
				if(b > firstMoney) {
					System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
				}else {
					isc = false;
				}
			}
			tmpBalance = (firstMoney-b);
			isc = true;
			
			System.out.println("뱅커에 배팅하셨습니다. 추가로 배팅할 금액을 입력해주세요.\n");
			
			System.out.println("Tie에 배팅 할 금액을 입력해주세요.");
			t = betTie(tmpBalance);
			tmpBalance -= t;
			
			System.out.println("PlayerPair에 배팅 할 금액을 입력해주세요.");
			pp = betPlayerPair(tmpBalance);
			tmpBalance -= pp;
			
			System.out.println("BankerPair에 배팅 할 금액을 입력해주세요.");
			bp = betBankerPair(tmpBalance);
			tmpBalance -= bp;
			
			break;
			
		default:
			System.out.println("잘못된 입력입니다. 1 (Player) 또는 2 (Banker) 숫자를 입력하여 배팅을 진행해주세요.");
		}
		
		// sum : 배팅한 금액의 총 합 , test용 출력문
		sum = p+b+t+pp+bp;
		System.out.println("player"+p);
		System.out.println("banker"+b);
		System.out.println("tie"+t);
		System.out.println("playerpair"+pp);
		System.out.println("bankerpair"+bp);
		System.out.println("배팅한 금액의 총합은 "+sum);
		System.out.println("남은 잔액은 "+(tmpBalance));
		
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
				System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
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
	 * @return user.getBetTie
	 */
	private int betPlayerPair(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetPlayerPair();
		boolean isc = true;
		while (isc) {
			input = InputVal.returnInt();
			if (input > tmpbal) {
				System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
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
	 * @return user.getBetTie
	 */
	private int betBankerPair(int tmpbal) {
		User user = User.getInstance();
		int input = user.getBetBankerPair();
		boolean isc = true;
		while (isc) {
			input = InputVal.returnInt();
			if (input > tmpbal) {
				System.out.println("가지고 있는 금액보다 많이 배팅할 수 없습니다. 다시 입력해주세요.");
			}else {
				isc = false;
			}
		}
		return input;
	}
	
}

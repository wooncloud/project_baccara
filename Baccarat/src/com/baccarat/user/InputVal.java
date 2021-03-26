package com.baccarat.user;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputVal {

	public static int returnInt() {
		int money = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				money = scan.nextInt();
				if(money<0) {
					System.err.println("잘못 입력하셨습니다. 0 보다 큰 값을 입력해주세요.");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("잘못 입력하셨습니다. 숫자를 입력해주세요.");
			}
		}
		return money;
	}
	
//	public static String returnString() {
//		String game = null;
//		Scanner scan = new Scanner(System.in);
//		game = scan.nextLine();
//		return game;
//	}
	
}

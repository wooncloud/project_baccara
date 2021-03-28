package com.baccarat.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputVal {

	public static int returnInt() {
		int val = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				val = scan.nextInt();
				if (val < 0) {
					System.err.println("잘못 입력하셨습니다. 0 보다 큰 값을 입력해주세요.");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("잘못 입력하셨습니다. 숫자를 입력해주세요.");
			}
		}
		return val;
	}

	// good

	public static String returnString() {
		String val = null;

		Scanner scan = new Scanner(System.in);
		val = scan.nextLine();

		return val;
	}

}

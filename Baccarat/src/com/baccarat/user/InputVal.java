package com.baccarat.user;

import java.util.Scanner;

public class InputVal {

	public static int returnInt() {
		int money;
		Scanner scan = new Scanner(System.in);
		money = scan.nextInt();
		return money;
	}
	
	public static String returnString() {
		String game;
		Scanner scan = new Scanner(System.in);
		game = scan.nextLine();
		return game;
	}
	
	
}

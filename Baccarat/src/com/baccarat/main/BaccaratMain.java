package com.baccarat.main;

import com.baccarat.user.Betting;
import com.baccarat.user.InputVal;
import com.baccarat.user.User;

public class BaccaratMain {

	public static void main(String[] args) {
		
		// InputVal test
//		System.out.println(InputVal.returnInt());
		
		// test
		Betting bet = new Betting();
		User user = User.getInstance();
		bet.startBet(user);
		

		
		
		
		
		
		
	}

}

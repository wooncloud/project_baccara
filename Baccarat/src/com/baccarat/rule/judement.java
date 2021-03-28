package com.baccarat.rule;

public class judement {
	
	static String judgmentP = null;
	public static String judgeP(int playerTwosum, int BankerTwosum ) {
		if (playerTwosum>=0&&playerTwosum<=5) {
			System.out.println("Player : Draw!!"+" / "+"추가카드 1장\n");
			judgmentP= "draw";
		}else if(playerTwosum==6 || playerTwosum ==7) {
			System.out.println("Player : Stand!!\n");
			judgmentP="stand";
		}else if(playerTwosum==8 || playerTwosum==9) {
			System.out.println("Player : Natural!!\n");
			judgmentP="natural" ;
		}else if(BankerTwosum==8 || BankerTwosum==9) {
			System.out.println("Player : Natural!!\n");
			judgmentP="natural" ;
		}
		return judgmentP;
	}
	
	static String judgmentB = null;
	public static String judgeB(int playerTwosum, int BankerTwosum ) {
		
		if (BankerTwosum>=0&&BankerTwosum<=5) {
			System.out.println("banker : Draw!!"+" / "+"추가카드 1장\n");
			judgmentB= "Draw";
		}else if(BankerTwosum==6 || BankerTwosum ==7) {
			System.out.println("banker : Stand!!\n");
			judgmentB="Stand";
		}else if(BankerTwosum==8 || BankerTwosum==9) {
			System.out.println("banker : Natural!!\n");
			judgmentB="Natural" ;
		}else if(BankerTwosum==8 || BankerTwosum==9) {
			System.out.println("banker : Natural!!\n");
			judgmentB="Natural" ;
		}
		return judgmentB;
	}
}

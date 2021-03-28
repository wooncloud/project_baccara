package com.baccarat.rule;

public class judement {
	private static String judgmentP = null;
	private static String judgmentB = null;

	/**
	 * 플레이어가 서드를 받을 수 있는지 못 받는지 결정 여부
	 * @param playerTwosum
	 * @param bankerTwosum
	 * @return
	 */
	public static String judgeP(int playerTwosum, int bankerTwosum) {
		if (playerTwosum >= 0 && playerTwosum <= 5) {
			System.out.println("Player : Draw!!" + " / " + "추가카드 1장\n");
			judgmentP = "draw";
		} else if (playerTwosum == 6 || playerTwosum == 7) {
			System.out.println("Player : Stand!!\n");
			judgmentP = "stand";
		} else if (playerTwosum == 8 || playerTwosum == 9) {
			System.out.println("Player : Natural!!\n");
			judgmentP = "natural";
		} else if (bankerTwosum == 8 || bankerTwosum == 9) {
			System.out.println("Player : Natural!!\n");
			judgmentP = "natural";
		}
		return judgmentP;
	}

	/**
	 * 뱅커가 서드를 받을 수 있는지 못 받는지 결정 여부
	 * @param playerTwosum
	 * @param bankerTwosum
	 * @return
	 */
	public static String judgeB(int playerTwosum, int bankerTwosum) {

		if (bankerTwosum >= 0 && bankerTwosum <= 5) {
			System.out.println("banker : Draw!!" + " / " + "추가카드 1장\n");
			judgmentB = "Draw";
		} else if (bankerTwosum == 6 || bankerTwosum == 7) {
			System.out.println("banker : Stand!!\n");
			judgmentB = "Stand";
		} else if (bankerTwosum == 8 || bankerTwosum == 9) {
			System.out.println("banker : Natural!!\n");
			judgmentB = "Natural";
		} else if (bankerTwosum == 8 || bankerTwosum == 9) {
			System.out.println("banker : Natural!!\n");
			judgmentB = "Natural";
		}
		return judgmentB;
	}
}

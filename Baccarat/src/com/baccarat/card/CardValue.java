package com.baccarat.card;

public class CardValue {

	// point value 점수 밸류 뽑기
	public static int Value(String xCard) {
		String fVal = xCard.substring(1);// face value 추출// System.out.println(fVal);
		int pVal = 0;
		if (fVal.equals("10") || fVal.equals("J") || fVal.equals("Q") || fVal.equals("K")) {
			pVal = 0;
		} else if (fVal.equals("A")) {
			pVal = 1;
		} else {
			pVal = Integer.parseInt(fVal);
		}
		return pVal; // return point value
	}
}

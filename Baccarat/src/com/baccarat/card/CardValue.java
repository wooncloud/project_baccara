package com.baccarat.card;
public class CardValue {
	
	
	//point value 점수 밸류 뽑기
	public static int Value(String xCard) {
		String fVal= xCard.substring(1);// face value 추출//		System.out.println(fVal);
		int pVal = 0; 
		if ( fVal.equals("10") || fVal.equals("J")|| fVal.equals("Q")|| fVal.equals("K") ) {
			 pVal= 0 ; 
		} else if (fVal.equals("A")){ 
			pVal=1;
		}else {
			pVal=Integer.parseInt(fVal);
		}
//		 System.out.println(pVal); 
		return  pVal; //return point value
	}
	
/**
 * point value로 딜러 연산룰 부분에서 판단	
 * 드로우 및 뱅서드 판단시 
 */
		
}

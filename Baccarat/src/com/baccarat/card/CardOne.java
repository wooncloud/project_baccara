package com.baccarat.card;

/**
 * CardOne 클래스는 한장의 카드(그림+숫자)를 생성하는 클래스
 * 
 * @author jsh
 *
 */
public class CardOne {

	public String card;

	public static final String[] SHAPE = { "◆", "♠", "♥", "♣" };
	public static final String[] NUMBER = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	public CardOne() {
		makeCardOne();
	}

	public void makeCardOne() {
		int s = (int) (Math.random() * SHAPE.length);
		int n = (int) (Math.random() * NUMBER.length);
		card = SHAPE[s] + NUMBER[n];
	}

	@Override
	public String toString() {
		return card;
	}

	@Override
	public int hashCode() {
		return card.hashCode() + 137;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardOne other = (CardOne) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		return true;
	}

}

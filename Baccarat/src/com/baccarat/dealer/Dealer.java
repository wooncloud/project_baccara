package com.baccarat.dealer;

import java.util.ArrayList;
import java.util.Arrays;

import com.baccarat.card.CardCase_JCF;
import com.baccarat.card.CardOne;
import com.baccarat.card.CardValue;
import com.baccarat.rule.BaccaratGame_Rule;
import com.baccarat.rule.Judge_PB;
import com.baccarat.user.Betting;
import com.baccarat.user.User;

public class Dealer {

	// 카드케이스 객체
	private CardCase_JCF cardCase;
	// 카드 룰
	private BaccaratGame_Rule rule;

	// 뽑은 카드
	private ArrayList<CardOne> playerCards = new ArrayList<CardOne>();
	private ArrayList<CardOne> bankerCards = new ArrayList<CardOne>();

	public Dealer() {
		// 카드케이스 생성
		cardCase = new CardCase_JCF();
		// 카드 룰 생성
		rule = new BaccaratGame_Rule();
	}

	/**
	 * 딜러가 게임의 흐름을 제어한다.
	 */
	public void gameFlow() {
		int winner = 0;
		boolean isPlayerPair = false;
		boolean isBankerPair = false;
		playerCards.clear();
		bankerCards.clear();

		// System.out.println(User.getInstance().getBalance()); // 테스트용

		// 플레이어 객체를 받아와서 배팅 ------------------------------
		Betting bet = new Betting();

		System.out.println("\n\n[ --- 배팅을 시작합니다. --- ]");
		bet.startBet();
		System.out.println("[ --- 배팅 종료 --- ]\n\n");

		// 카드 뽑기 ------------------------------
		cardDraw();

		// 페어 체크 ------------------------------
		isPlayerPair = BaccaratGame_Rule.checkPair(playerCards.get(0), playerCards.get(1));
		isBankerPair = BaccaratGame_Rule.checkPair(bankerCards.get(0), bankerCards.get(1));

		// 처음 뽑은 카드의 점수 얻기 ------------------------------
		int playerScore = BaccaratGame_Rule.cardScoreSum(playerCards.toArray(new CardOne[playerCards.size()]));
		int bankerScore = BaccaratGame_Rule.cardScoreSum(bankerCards.toArray(new CardOne[playerCards.size()]));

		// 출력
		cardPrint(playerScore, bankerScore);

		String pJudgeResult = Judge_PB.judgePlayer(playerScore);

		// Natural인지 확인
		if (pJudgeResult == "natural") {
			// Natural로 승부
			System.out.println("[ - 플레이어 Natural - ]");

			// 승부
			winner = rule.winOrLose(playerScore, bankerScore);
		}
		// 뱅커 네츄럴인지 확인
		else if (Judge_PB.isBankerNatural(bankerScore)) {
			// Natural로 승부
			System.out.println("[ - 뱅커 Natural - ]");

			// 승부
			winner = rule.winOrLose(playerScore, bankerScore);
		}
		// 플레이어, 뱅커 둘다 Natural이 아니면 stand or draw
		else {
			// 플레이어가 draw여부 체크해서 카드 드로우
			if (BaccaratGame_Rule.isDraw(pJudgeResult)) {
				System.out.println("[ - 플레이어 카드 Draw - ]");
				playerCards.add(cardCase.randomOne());
			} else {
				System.out.println("[ - 플레이어 Stand - ]");
			}

			// 플레이어 서드카드와 서드카드 점수 얻기
			CardOne pThird = playerCards.get(playerCards.size() - 1);
			int pThirdScore = CardValue.Value(pThird.getCard());

			// 뱅커 드로우 여부 확인
			String bJudgeResult = Judge_PB.judgeBankThird(bankerScore, pThirdScore);
			if (BaccaratGame_Rule.isDraw(bJudgeResult)) {
				System.out.println("[ - 뱅커 카드 Draw - ]");
				bankerCards.add(cardCase.randomOne());
			} else {
				System.out.println("[ - 뱅커 Stand - ]");
			}

			// 점수 재 결산
			playerScore = BaccaratGame_Rule.cardScoreSum(playerCards.toArray(new CardOne[playerCards.size()]));
			bankerScore = BaccaratGame_Rule.cardScoreSum(bankerCards.toArray(new CardOne[bankerCards.size()]));

			cardPrint(playerScore, bankerScore);

			// 승부
			winner = rule.winOrLose(playerScore, bankerScore);
		}

		// 결과
		System.out.println(result(winner) + "\n\n");

		// 배당
		allocation(winner, isPlayerPair, isBankerPair);
	}

	/**
	 * 카드 케이스로부터 카드를 받는다.<br>
	 * 처음에 player와 banker 각각 총 2장씩 카드를 지급받는다.<br>
	 * 카드를 받을 때, player > banker > player > banker 순서로 카드를 받음.
	 */
	public void cardDraw() {
		playerCards.add(cardCase.randomOne());
		bankerCards.add(cardCase.randomOne());
		playerCards.add(cardCase.randomOne());
		bankerCards.add(cardCase.randomOne());
	}

	private String result(int winner) {
		String result = "";
		switch (winner) {
		case 1:
			result = "[ --- 플레이어 승 (Player Win) --- ]";
			break;
		case 2:
			result = "[ --- 뱅커 승 (Banker Win) --- ]";
			break;
		case 3:
			result = "[ --- TIE --- ]";
			break;
		default:
			break;
		}

		return result;
	}

	/**
	 * 배당 계산 (버려지는 돈은 모르겠다아)
	 */
	private void allocation(int winner, boolean isPP, boolean isBP) {
		User user = User.getInstance();

		int p = 0;
		int b = 0;
		int t = 0;
		int pp = 0;
		int bp = 0;

		switch (winner) {
		case 1:
			p = (int) (user.getBetPlayer() * BaccaratGame_Rule.PLAYER_WIN);
			break;
		case 2:
			b = (int) (user.getBetBanker() * BaccaratGame_Rule.BANKER_WIN);
			break;
		case 3:
			t = (int) (user.getBetTie() * BaccaratGame_Rule.TIE);
			break;
		default:
			break;
		}

		// 페어 배팅 계산
		if (isPP) {
			pp = (int) (user.getBetPlayerPair() * BaccaratGame_Rule.PAIR);
		}
		if (isBP) {
			bp = (int) (user.getBetBankerPair() * BaccaratGame_Rule.PAIR);
		}

		// 수금
		user.setDividends(p, b, t, pp, bp);
	}

	/**
	 * 유저의 돈을 보고 파산했는지 확인한다.
	 * 
	 * @return 유저가 파산했으면 true 아니면 false
	 */
	public boolean userMoneyCheck(User user) {
		boolean isc = false;

		if (user.getBalance() <= 0) {
			isc = true;
		}

		return isc;
	}

	private void cardPrint(int ps, int bs) {
		System.out.println("\n++++++++++++++++++++++++++++++");
		System.out.printf("[ 플레이어 카드 : %s -> (%d) ]\n", Arrays.toString(playerCards.toArray()), ps);
		System.out.printf("[ 뱅커 카드 : %s -> (%d) ]\n", Arrays.toString(bankerCards.toArray()), bs);
		System.out.println("++++++++++++++++++++++++++++++\n");
	}

}

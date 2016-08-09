import java.util.Collections;

import entities.Card;
import entities.Deck;
import pack.PackWithJoker;

public class Driver {
	public static void main(String[] args) {
		 debug();
	}

	public static void debug() {
		testDeck();
		testCard();
		testHand();
	}

	public static void testHand() {
		PokerHand hand = new PokerHand(2);
		hand.addCard(new Card("10", "SPADE"));
		hand.addCard(new Card("10", "DIAMOND"));
		PokerHand table = new PokerHand(3);
		table.addCard(new Card("A", "SPADE"));
		table.addCard(new Card("Q", "HEART"));
		table.addCard(new Card("Q", "CLUB"));
		assert hand.assess(table).equals("Two Pair");
	}

	public static void testDeck() {
		try {
			Deck deck = new Deck(1, PackWithJoker.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testCard() {
		Card card1 = new Card("1", "SPADE");
		Card card2 = new Card("1", "SPADE");
		Card card3 = new Card("2", "SPADE");
		Card card4 = new Card("1", "HEART");
		assert card1.equals(card2);
		assert !card1.equals(card3);
		assert !card1.equals(card4);

	}
}

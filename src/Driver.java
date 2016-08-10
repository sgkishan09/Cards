import java.util.Collections;

import entities.Card;
import entities.Deck;
import pack.PackWithJoker;
import pack.PackWithoutJoker;

public class Driver {
	public static void main(String[] args) {
		try {
			debugPokerHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void debug() {
		testDeck();
	}

	public static void runAssessPoker() throws Exception {
		Deck deck = new Deck(1, PackWithoutJoker.class);
		PokerHand hand = new PokerHand(deck.pick(2));
		PokerHand table = new PokerHand(deck.pick(3));
		System.out.println(hand);
		System.out.println(table);
		System.out.println(hand.assess(table));
	}

	public static void debugPokerHand() {
		PokerHand hand = new PokerHand(2);
		hand.addCard(new Card("A", "SPADE"));
		hand.addCard(new Card("K", "SPADE"));
		PokerHand table = new PokerHand(3);
		table.addCard(new Card("Q", "SPADE"));
		table.addCard(new Card("J", "SPADE"));
		table.addCard(new Card("10", "SPADE"));
		System.out.println(hand);
		System.out.println(table);
		System.out.println("------------------------");
		System.out.println(hand.assess(table));
	}

	public static void testDeck() {
		try {
			Deck deck = new Deck(1, PackWithJoker.class);
			deck.sort();
			Collections.sort(deck.cards, new CardComparatorByValue());
			System.out.println(deck);
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
